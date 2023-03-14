package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfigImplementation implements AppConfig {

    @Value("${app.apiKey}")
    private String apiKey;
    @Value("${app.username}")
    private String username;
    @Value("${app.password}")
    private String password;


    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
