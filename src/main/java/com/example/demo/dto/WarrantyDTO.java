package com.example.demo.dto;

import java.time.LocalDate;

public class WarrantyDTO {

    private Long userId;
    private Long productId;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String serialNumber;

    public WarrantyDTO() {}

    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public Long getProductId() {
        return productId;
    }
 
    public void setProductId(Long productId) {
        this.productId = productId;
    }
 
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
 
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
 
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
 
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
 
    public String getSerialNumber() {
        return serialNumber;
    }
 
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
