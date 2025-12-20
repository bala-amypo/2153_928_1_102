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
