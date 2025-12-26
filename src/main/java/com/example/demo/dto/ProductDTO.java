package com.example.demo.dto;

public class ProductDTO {

    private String name;
    private String brand;
    private String modelNumber;
    private String category;

    public ProductDTO() {}

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getBrand() {
        return brand;
    }
 
    public void setBrand(String brand) {
        this.brand = brand;
    }
 
    public String getModelNumber() {
        return modelNumber;
    }
 
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
 
    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }
}
