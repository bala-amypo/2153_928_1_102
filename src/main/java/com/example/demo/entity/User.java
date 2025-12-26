package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}
