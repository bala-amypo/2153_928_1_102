package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User Savedata(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
