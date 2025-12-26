package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;

public interface UserService {

    User register(RegisterRequest request);

    String loginAndGenerateToken(AuthRequest request);

    User findByEmail(String email);
}
