package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    public AlertLog() {}

    // ===== lifecycle =====
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    // ===== builder (REQUIRED) =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Warranty warranty;

        public Builder warranty(Warranty warranty) {
            this.warranty = warranty;
            return this;
        }

        public AlertLog build() {
            AlertLog log = new AlertLog();
            log.warranty = this.warranty;
            log.prePersist();
            return log;
        }
    }
}
