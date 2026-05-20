package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Order(1) // Runs first in the security/filter chain
public class RateLimitingFilter implements Filter {

    // Configuration constants
    private static final int MAX_REQUESTS_PER_MINUTE = 5;
    private static final long TIME_WINDOW_MS = Duration.ofMinutes(1).toMillis();

    // Thread-safe cache storing: IP Address -> ClientRequestTracker
    private final Map<String, ClientRequestTracker> cache = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest httpRequest && response instanceof HttpServletResponse httpResponse) {
            String clientIp = httpRequest.getRemoteAddr();
            long currentTime = System.currentTimeMillis();

            // Compute or retrieve the tracker for this specific IP address
            ClientRequestTracker tracker = cache.compute(clientIp, (ip, currentTracker) -> {
                if (currentTracker == null || (currentTime - currentTracker.windowStartTime > TIME_WINDOW_MS)) {
                    // Start a brand new 1-minute window
                    return new ClientRequestTracker(currentTime, 1);
                } else {
                    // Increment the count within the existing window
                    currentTracker.requestCount.incrementAndGet();
                    return currentTracker;
                }
            });

            // Check if the client crossed the threshold
            if (tracker.requestCount.get() > MAX_REQUESTS_PER_MINUTE) {
                httpResponse.setStatus(429); // Too Many Requests
                httpResponse.setContentType("application/json");
                httpResponse.getWriter().write("{\"error\": \"Too many requests. Please try again later.\"}");
                return; // Short-circuit the request; do NOT call chain.doFilter()
            }
        }

        // Pass the request forward down the chain to the Controller
        chain.doFilter(request, response);
    }

    // Helper class to bundle window state per client
    private static class ClientRequestTracker {
        private final long windowStartTime;
        private final AtomicInteger requestCount;

        public ClientRequestTracker(long windowStartTime, int initialCount) {
            this.windowStartTime = windowStartTime;
            this.requestCount = new AtomicInteger(initialCount);
        }
    }
}
