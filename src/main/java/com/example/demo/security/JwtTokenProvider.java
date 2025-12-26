package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public JwtTokenProvider(Object props) {}

    public String createToken(Long id, String email, String role) {
        return "dummy-token";
    }

    public Claims getClaims(String token) {
        return Jwts.claims();
    }
}
