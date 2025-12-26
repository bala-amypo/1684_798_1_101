package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void register(UserRegisterDto dto) {
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-token");
    }
}
