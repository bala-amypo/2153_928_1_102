package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtProperties {

    // these fields are set via reflection in tests
    private String secret;
    private Long expirationMs;
}
