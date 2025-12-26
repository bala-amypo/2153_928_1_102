package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    String loginAndGenerateToken(LoginRequest request);
}
