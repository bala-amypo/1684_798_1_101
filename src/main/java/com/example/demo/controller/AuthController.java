package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.config.JwtProvider;
import com.example.demo.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        
        Set<Role> roles = new HashSet<>();
        roles.add(Role.valueOf("ROLE_" + request.getRole()));
        
        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .roles(roles)
            .createdAt(LocalDateTime.now())
            .build();
        
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
            .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
            .map(user -> {
                Set<String> roles = new HashSet<>();
                user.getRoles().forEach(role -> roles.add(role.name()));
                String token = jwtProvider.generateToken(user.getEmail(), user.getId(), roles);
                return ResponseEntity.ok(new AuthResponse(token));
            })
            .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
    
    @Data
    static class RegisterRequest {
        private String name;
        private String email;
        private String password;
        private String role = "USER";
    }
    
    @Data
    static class LoginRequest {
        private String email;
        private String password;
    }
    
    @Data
    static class AuthResponse {
        private final String token;
    }
}