package com.mingi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String initialBean() {
        return "Initial Bean Loaded";
    }
}