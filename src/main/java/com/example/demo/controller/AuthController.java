package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    // Register a new user
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User u = userService.login(user.getEmail(), user.getPassword());
        if(u == null){
            return "Invalid credentials";
        }
        return "Login successful";
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
