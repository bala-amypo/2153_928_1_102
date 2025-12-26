// src/main/java/com/example/demo/entity/AlertSchedule.java
package com.example.demo.entity;

import jakarta.persistence.*;
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
    
    @Column(nullable = false)
    private Integer daysBeforeExpiry;
    
    @Column(nullable = false)
    @Builder.Default
    private Boolean enabled = true;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;
    
    @PrePersist
    @PreUpdate
    private void validateDaysBeforeExpiry() {
        if (daysBeforeExpiry < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry must be non-negative");
        }
    }
}