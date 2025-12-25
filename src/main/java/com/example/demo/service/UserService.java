package com.example.demo.service;

import com.example.demo.dto.*;

public interface UserService {
    void register(UserRegisterDto dto);
    AuthResponse login(AuthRequest request);
}
