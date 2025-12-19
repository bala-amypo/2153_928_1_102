package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){ this.userRepository = userRepository; }

    @Override
    public User register(User user){
        if(userRepository.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email exists");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){ return userRepository.findAll(); }

    @Override
    public User getUserById(Long id){ return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); }

    @Override
    public void deleteUser(Long id){ userRepository.deleteById(id); }
}
