package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;

public interface UserService {

    User register(UserRegisterDto dto);

    String login(AuthRequest request);

    User findByEmail(String email);
}
