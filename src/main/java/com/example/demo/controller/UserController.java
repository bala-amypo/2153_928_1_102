package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){ 
        this.userService = userService; 
    }

    @PostMapping("/id")
    public User save(@RequestBody User user){ 
        return userService.Savadata(user); 
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
