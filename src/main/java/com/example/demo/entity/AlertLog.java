package com.example.demo.entity;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertLog {
    private Long id;
    private String message;
    private LocalDateTime alertTime;

    // Required by service for saving alert timestamp
    public void prePersist() {
        this.alertTime = LocalDateTime.now();
    }
}
