package com.example.demo.entity;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class AlertLog {
    private Long id;
    private String message;
    private LocalDateTime sentAt;

    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }
}
