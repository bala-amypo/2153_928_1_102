package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the product", example = "1")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Schema(description = "Product name", example = "Laptop")
    private String name;

    @NotBlank(message = "Model number cannot be empty")
    @Size(max = 50, message = "Model number must be less than 50 characters")
    @Schema(description = "Product model number", example = "LAP1234")
    private String modelNumber;

    @NotBlank(message = "Category cannot be empty")
    @Size(max = 50, message = "Category must be less than 50 characters")
    @Schema(description = "Product category", example = "Electronics")
    private String category;
}
