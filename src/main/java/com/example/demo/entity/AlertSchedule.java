package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warranty_id", nullable = false)
    @NotNull(message = "Warranty must be provided")
    private Warranty warranty;

    @NotNull(message = "Days before expiry is required")
    @Min(value = 0, message = "Days before expiry must be 0 or greater")
    @Column(name = "days_before_expiry", nullable = false)
    private Integer daysBeforeExpiry;

    @NotNull(message = "Enabled flag is required")
    @Column(nullable = false)
    private Boolean enabled;

    @Column(name = "alert_message", nullable = false)
    private String alertMessage;

    @Column(name = "alert_time", nullable = false)
    private LocalDateTime alertTime;

    // 🔹 AUTO-FILL LOGIC
    @PrePersist
    public void autoFillFields() {

        // set time
        if (alertTime == null) {
            alertTime = LocalDateTime.now();
        }

        // generate message based on daysBeforeExpiry
        if (alertMessage == null || alertMessage.isBlank()) {

            if (daysBeforeExpiry == 0) {
                alertMessage = "Warranty expires today";
            } else if (daysBeforeExpiry == 1) {
                alertMessage = "Only 1 day left before warranty expiry";
            } else if (daysBeforeExpiry <= 10) {
                alertMessage = "Only " + daysBeforeExpiry +
                        " days left before warranty expiry";
            } else {
                alertMessage = "Warranty expiring in " +
                        daysBeforeExpiry + " days";
            }
        }
    }
}
