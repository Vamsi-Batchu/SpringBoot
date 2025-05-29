package com.example.servicea.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicea")
public class ServiceAController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from ServiceA";
    }
}
