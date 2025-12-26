package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    private LocalDate purchaseDate;

    private LocalDate expiryDate;

    @Column(nullable = false)
    private String status;   // ✅ REQUIRED (FIX)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;       // ✅ REQUIRED (FIX)

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
