package com.example.demo.security;

import com.example.demo.config.JwtProperties;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenProvider {

    private final JwtProperties properties;

    public JwtTokenProvider(JwtProperties properties) {
        this.properties = properties;
    }

    public String createToken(Long userId, String email, String role) {

        return Jwts.builder()
                .claim("userId", userId.intValue())
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(
                        System.currentTimeMillis()
                                + properties.getExpirationMs()))
                .signWith(SignatureAlgorithm.HS256,
                        properties.getSecret())
                .compact();
    }

    public boolean validateToken(String token) {
        Jwts.parser()
                .setSigningKey(properties.getSecret())
                .parseClaimsJws(token);
        return true;
    }

    public Jws<Claims> getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(properties.getSecret())
                .parseClaimsJws(token);
    }
}
