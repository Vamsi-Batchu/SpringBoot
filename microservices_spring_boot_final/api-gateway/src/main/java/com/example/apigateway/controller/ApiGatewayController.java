package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apigateway")
public class ApiGatewayController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from ApiGateway";
    }
}
