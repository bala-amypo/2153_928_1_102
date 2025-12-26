package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import com.example.demo.entity.User;

public interface UserService {

    // Register using DTO
    User registerUser(RegisterRequest request);

    // Register using User entity (needed for tests)
    User register(User user);

    // Login and generate JWT token
    String loginAndGenerateToken(AuthRequest request);

    // Find user by email (needed for tests)
    User findByEmail(String email);
}
