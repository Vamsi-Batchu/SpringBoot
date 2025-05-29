package com.example.rabbitmqconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {{

    @RabbitListener(queues = "demo-queue")
    public void handleMessage(String message) {{
        System.out.println("Received message: " + message);
    }}
}}
