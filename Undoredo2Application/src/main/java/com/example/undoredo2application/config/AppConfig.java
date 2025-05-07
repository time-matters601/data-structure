package com.example.undoredo2application.config;


import com.example.undoredo2application.model.TextContent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TextContent textContent() {
        return new TextContent();
    }
}
