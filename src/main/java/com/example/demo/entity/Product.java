// src/main/java/com/example/demo/entity/Product.java
package com.example.demo.entity;

import jakarta.persistence.*;
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
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private String modelNumber;
    
    @Column(nullable = false)
    private String category;
    
    // Constructors
    public Product(String name, String brand, String modelNumber, String category) {
        this.name = name;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.category = category;
    }
}