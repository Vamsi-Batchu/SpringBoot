package com.example.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b")
public interface ServiceBClient {{
    @GetMapping("/api/serviceb/hello")
    String callServiceB();
}}
