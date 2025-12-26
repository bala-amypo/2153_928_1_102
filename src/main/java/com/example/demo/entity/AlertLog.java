package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime sentAt;

    public AlertLog() {}

    // ✅ TEST CALLS THIS DIRECTLY
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
