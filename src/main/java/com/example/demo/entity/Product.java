package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;

    @Column(nullable = false)
    private String modelNumber;      // REQUIRED

    @Column(nullable = false)
    private String category;         // REQUIRED

    private Integer warrantyPeriodMonths;

    // Optional: Static factory method to make builder usage more explicit in tests
    public static Product createProduct(Long id, String name, String brand, String modelNumber, String category, Integer warrantyPeriodMonths) {
        return Product.builder()
                .id(id)
                .name(name)
                .brand(brand)
                .modelNumber(modelNumber)
                .category(category)
                .warrantyPeriodMonths(warrantyPeriodMonths)
                .build();
    }
}
