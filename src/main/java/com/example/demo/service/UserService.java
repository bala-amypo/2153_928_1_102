package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthResponse;

public interface UserService {

    AuthResponse register(RegisterRequest request);

    String loginAndGenerateToken(AuthRequest request);
}
