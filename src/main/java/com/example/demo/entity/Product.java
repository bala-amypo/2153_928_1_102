package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    // ✅ REQUIRED FIELD
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    // ✅ EXACT MESSAGE REQUIRED BY QUESTION
    @NotBlank(message = "Model number required")
    private String modelNumber;

    // ✅ EXACT MESSAGE REQUIRED BY QUESTION
    @NotBlank(message = "Category required")
    private String category;
}
