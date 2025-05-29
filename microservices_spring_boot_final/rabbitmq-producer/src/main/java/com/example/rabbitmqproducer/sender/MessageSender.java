package com.example.rabbitmqproducer.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class MessageSender {{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String sendMessage(@RequestBody String message) {{
        rabbitTemplate.convertAndSend("demo-queue", message);
        return "Message sent: " + message;
    }}
}}
