package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int daysBeforeExpiry;

    public AlertSchedule() {}

    public int getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(int daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    // ✅ BUILDER REQUIRED BY TEST
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
