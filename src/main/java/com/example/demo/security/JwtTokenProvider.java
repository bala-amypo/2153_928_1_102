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

        Claims claims = Jwts.claims();
        claims.put("userId", userId.intValue()); // tests expect Integer
        claims.put("email", email);
        claims.put("role", role);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + properties.getExpirationMs());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, properties.getSecret())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Jws<Claims> getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(properties.getSecret())
                .parseClaimsJws(token);
    }
}
