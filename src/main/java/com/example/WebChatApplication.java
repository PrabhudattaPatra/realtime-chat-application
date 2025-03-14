package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WebChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebChatApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStart() {
        System.out.println("\n\n" + 
            "==========================================================\n" +
            "🚀 Chat Application Started Successfully!\n" +
            "==========================================================\n" +
            "To use the chat application:\n" +
            "1. Open your browser\n" +
            "2. Go to: http://localhost:8081\n" +
            "3. Enter your name and start chatting!\n" +
            "\n" +
            "To share with others on your network:\n" +
            "Share this link: http://192.168.211.2:8081\n" +
            "==========================================================\n");
    }
} 