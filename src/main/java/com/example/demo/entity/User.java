package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the user", example = "1")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name must be less than 50 characters")
    @Schema(description = "User's full name", example = "John Doe")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Schema(description = "User's email address", example = "john.doe@example.com")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Schema(description = "User's password", example = "secret123")
    private String password;

    @NotBlank(message = "Role cannot be empty")
    @Schema(description = "User's role", example = "USER")
    private String role;
}
