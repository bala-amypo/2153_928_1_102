package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        return true;
    }

    public String getUsernameFromToken(String token) {
        return "test@example.com";
    }
}
