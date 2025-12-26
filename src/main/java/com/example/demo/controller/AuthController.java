package com.example.demo.controller;

import com.example.demo.dto.aReqAuthest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return userService.loginAndGenerateToken(request);
    }
}
