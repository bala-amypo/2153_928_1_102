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
    private Warranty warranty;

    public AlertLog() {}

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getSentAt() { return sentAt; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Warranty warranty;
        private String message;

        public Builder warranty(Warranty w) {
            this.warranty = w; return this;
        }

        public Builder message(String m) {
            this.message = m; return this;
        }

        public AlertLog build() {
            AlertLog l = new AlertLog();
            l.warranty = this.warranty;
            l.message = this.message;
            l.prePersist();
            return l;
        }
    }
}
