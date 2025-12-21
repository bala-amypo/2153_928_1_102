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

    // ManyToOne relationship with Warranty
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warranty_id", nullable = false)
    @NotNull(message = "Warranty must be provided")
    private Warranty warranty;

    // Ensure daysBeforeExpiry is not negative
    @NotNull(message = "Days before expiry is required")
    @Min(value = 0, message = "Days before expiry must be 0 or greater")
    @Column(name = "days_before_expiry", nullable = false)
    private Integer daysBeforeExpiry;

    // Enabled flag
    @NotNull(message = "Enabled flag is required")
    @Column(nullable = false)
    private Boolean enabled;

    // 🔹 AUTO-FILLED ALERT MESSAGE
    @Column(name = "alert_message", nullable = false)
    private String alertMessage;

    // 🔹 AUTO-FILLED ALERT TIME
    @Column(name = "alert_time", nullable = false)
    private LocalDateTime alertTime;

    // 🔹 AUTO SET BEFORE INSERT
    @PrePersist
    public void setDefaults() {

        if (alertTime == null) {
            alertTime = LocalDateTime.now();
        }

        if (alertMessage == null || alertMessage.isBlank()) {
            alertMessage = "Warranty expiring soon";
        }
    }
}
