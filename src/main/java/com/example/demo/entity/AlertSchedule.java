package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer daysBeforeExpiry;   // MUST be Integer
    private boolean enabled;
    private boolean sent;

    @ManyToOne
    private Warranty warranty;

    public AlertSchedule() {}

    // ===== getters/setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getDaysBeforeExpiry() { return daysBeforeExpiry; }

    // ===== builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer daysBeforeExpiry;
        private boolean enabled;
        private Warranty warranty;

        public Builder daysBeforeExpiry(Integer d) {
            this.daysBeforeExpiry = d; return this;
        }

        public Builder enabled(boolean e) {
            this.enabled = e; return this;
        }

        public Builder warranty(Warranty w) {
            this.warranty = w; return this;
        }

        public AlertSchedule build() {
            AlertSchedule a = new AlertSchedule();
            a.daysBeforeExpiry = this.daysBeforeExpiry;
            a.enabled = this.enabled;
            a.warranty = this.warranty;
            return a;
        }
    }
}
