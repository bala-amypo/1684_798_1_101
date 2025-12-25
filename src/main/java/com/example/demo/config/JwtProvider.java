package com.example.demo.config;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class JwtProvider {
    private final Set<String> roles = Set.of("USER");
}
