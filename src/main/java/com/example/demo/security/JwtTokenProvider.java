package com.example.demo.security;

import com.example.demo.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtTokenProvider {

    private String secret;
    private long expirationMs;

    // ✅ REQUIRED
    public JwtTokenProvider() {
        this.secret = "12345678901234567890123456789012";
        this.expirationMs = 3600000;
    }

    // ✅ REQUIRED BY TEST
    public JwtTokenProvider(JwtProperties properties) {
        this.secret = properties.getSecret();
        this.expirationMs = properties.getExpirationMs();
    }

    // ✅ REQUIRED BY TEST
    public String createToken(long userId, String email, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY TEST
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
