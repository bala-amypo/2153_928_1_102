package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    public AlertLog() {}

    // ===== lifecycle =====
    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    // ===== getters =====
    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getMessage() {
        return message;
    }

    // ===== builder (REQUIRED BY SERVICE + TESTS) =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Warranty warranty;
        private String message;

        public Builder warranty(Warranty warranty) {
            this.warranty = warranty;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public AlertLog build() {
            AlertLog log = new AlertLog();
            log.warranty = this.warranty;
            log.message = this.message;
            log.prePersist();
            return log;
        }
    }
}
