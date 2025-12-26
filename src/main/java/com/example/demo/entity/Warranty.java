// src/main/java/com/example/demo/entity/Warranty.java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "warranties", uniqueConstraints = {
    @UniqueConstraint(columnNames = "serialNumber")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDate purchaseDate;
    
    @Column(nullable = false)
    private LocalDate expiryDate;
    
    @Column(nullable = false, unique = true)
    private String serialNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (expiryDate.isBefore(purchaseDate) || expiryDate.isEqual(purchaseDate)) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
    }
}