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
        return userService.saveUser(user); 
        }

    @GetMapping("/all")
    public List<User> getUsers(){ return userService.getAllUsers(); }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){ return userService.getUserById(id); }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "Deleted successfully";
    }
}
