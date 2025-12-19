package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
