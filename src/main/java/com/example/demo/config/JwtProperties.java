package com.example.demo.config;

public class JwtProperties {

    // MUST be named exactly like this (tests use reflection)
    private String secret;
    private long expirationMs;

    public JwtProperties() {
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpirationMs() {
        return expirationMs;
    }

    public void setExpirationMs(long expirationMs) {
        this.expirationMs = expirationMs;
    }
}
