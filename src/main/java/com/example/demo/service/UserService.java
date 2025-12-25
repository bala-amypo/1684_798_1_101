package com.example.demo.service;

import com.example.demo.dto.*;

public interface UserService {
    com.example.demo.model.User register(UserRegisterDto dto);
    AuthResponse login(AuthRequest request);
    com.example.demo.model.User getByEmail(String email);
}
