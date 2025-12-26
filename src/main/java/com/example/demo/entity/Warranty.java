package com.example.demo.entity;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private Product product;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String serialNumber;
}
