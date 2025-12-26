package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter   // ✅ REQUIRED
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String brand;

    private Integer warrantyPeriodMonths; // getter generated

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Warranty> warranties;
}
