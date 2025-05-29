package com.example.serviceb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/serviceb")
public class ServiceBController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from ServiceB";
    }
}
