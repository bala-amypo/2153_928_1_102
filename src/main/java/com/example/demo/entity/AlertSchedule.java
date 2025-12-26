package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int daysBeforeExpiry;

    private boolean sent;

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    public AlertSchedule() {}

    // ===== getters & setters =====

    public int getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(int daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    // ===== builder (REQUIRED by tests) =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int daysBeforeExpiry;

        public Builder daysBeforeExpiry(int daysBeforeExpiry) {
            this.daysBeforeExpiry = daysBeforeExpiry;
            return this;
        }

        public AlertSchedule build() {
            AlertSchedule s = new AlertSchedule();
            s.setDaysBeforeExpiry(this.daysBeforeExpiry);
            return s;
        }
    }
}
