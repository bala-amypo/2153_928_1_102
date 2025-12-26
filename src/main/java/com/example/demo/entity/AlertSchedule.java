package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer daysBeforeExpiry;   // REQUIRED
    private Boolean sent;

    @ManyToOne
    private Warranty warranty;

    // Custom builder method for 'enabled'
    public static class AlertScheduleBuilder {
        public AlertScheduleBuilder enabled(boolean enabled) {
            this.sent = !enabled; // assuming 'sent' = false when enabled
            return this;
        }
    }
}
