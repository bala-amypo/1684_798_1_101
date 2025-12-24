package com.example.demo.security;

import com.example.demo.config.JwtProvider; // Make sure this is .config, not .security
import jakarta.servlet.FilterChain;
// ... rest of imports

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider; // This should be from config package
    // ... rest of the class
}