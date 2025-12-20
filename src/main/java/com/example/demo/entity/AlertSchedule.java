package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "alert_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Warranty must be provided")
    private Warranty warranty;

    @NotNull(message = "Days before expiry is required")
    @Min(value = 0, message = "Days before expiry must be 0 or greater")
    private Integer daysBeforeExpiry;

    @NotNull(message = "Enabled flag is required")
    private Boolean enabled;
}
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
