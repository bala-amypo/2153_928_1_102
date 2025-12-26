package com.example.demo.entity;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class Warranty {
    private Long id;
    private User user;
    private Product product;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String serialNumber;
}
