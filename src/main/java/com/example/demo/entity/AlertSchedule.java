package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Warranty warranty;

    private boolean sent;

    // ---- GETTERS & SETTERS ----

    public Long getId() {
        return id;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
