package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.jwt")
@Data
public class JwtConfig {
    private String secret;
    private Long expirationMs;
    private Long refreshExpirationMs;
    private String issuer;
    private String audience;
    
    // Default values
    public JwtConfig() {
        this.secret = "your-secret-key-change-in-production-please";
        this.expirationMs = 86400000L; // 24 hours
        this.refreshExpirationMs = 604800000L; // 7 days
        this.issuer = "inventory-app";
        this.audience = "inventory-users";
    }
}