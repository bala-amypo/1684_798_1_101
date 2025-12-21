package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        // TEMP dummy response (JWT logic can be added later)
        AuthResponse response = new AuthResponse();
        response.setToken("dummy-jwt-token");

        return ResponseEntity.ok(response);
    }
}
