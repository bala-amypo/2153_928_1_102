package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class AuthController {
    private final UserService userService;
    public UserController(UserService userService){ 
        this.userService = userService; 
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){ 
        return userService.register(user); 
        }

        @PostMapping("/login")
    public User login(@RequestBody User user){ 
        return userService.login(user); 
        }

   
}
