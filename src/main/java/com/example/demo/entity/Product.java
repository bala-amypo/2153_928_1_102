package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;

    @Column(nullable = false)
    private String modelNumber;

    @Column(nullable = false)
    private String category;

    private Integer warrantyPeriodMonths;

    public Product() {}

    public Product(Long id, String name, String brand,
                   String modelNumber, String category,
                   Integer warrantyPeriodMonths) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.category = category;
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getWarrantyPeriodMonths() { return warrantyPeriodMonths; }

    // ===== builder REQUIRED BY TEST =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String brand;
        private String modelNumber;
        private String category;
        private Integer warrantyPeriodMonths;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder brand(String brand) { this.brand = brand; return this; }
        public Builder modelNumber(String modelNumber) { this.modelNumber = modelNumber; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder warrantyPeriodMonths(Integer w) { this.warrantyPeriodMonths = w; return this; }

        public Product build() {
            return new Product(id, name, brand, modelNumber, category, warrantyPeriodMonths);
        }
    }
}
