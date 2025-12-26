package com.example.demo.repository;

import java.util.*;
import java.time.LocalDate;
import com.example.demo.entity.*;

public interface UserRepository {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
}
