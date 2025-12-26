package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import com.example.demo.entity.User;

import java.util.Optional;

public interface UserService {

    // Register using DTO
    User registerUser(RegisterRequest request);

    // Login and generate JWT token
    String loginAndGenerateToken(AuthRequest request);

    // Directly register a User (needed for tests)
    User register(User user);

    // Find a user by email (needed for tests)
    Optional<User> findByEmail(String email);
}
