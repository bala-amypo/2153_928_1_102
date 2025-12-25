package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userService.register(user);
        return new AuthResponse("User registered successfully");
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User dbUser = userService.findByEmail(request.getEmail());

        if (dbUser == null ||
                !passwordEncoder.matches(request.getPassword(), dbUser.getPassword())) {
            return new AuthResponse("Invalid credentials");
        }

        return new AuthResponse("Login successful");
    }
}
