package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "warranties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the warranty", example = "1")
    private Long id;

    @ManyToOne
    @NotNull(message = "User must be provided")
    @Schema(description = "User associated with the warranty")
    private User user;

    @ManyToOne
    @NotNull(message = "Product must be provided")
    @Schema(description = "Product associated with the warranty")
    private Product product;

    @NotNull(message = "Purchase date is required")
    @Schema(description = "Purchase date of the product", example = "2025-12-19")
    private LocalDate purchaseDate;

    @NotNull(message = "Expiry date is required")
    @Schema(description = "Expiry date of the warranty", example = "2026-12-19")
    private LocalDate expiryDate;

    @NotBlank(message = "Serial number cannot be empty")
    @Schema(description = "Serial number of the product", example = "SN123456789")
    private String serialNumber;
}
