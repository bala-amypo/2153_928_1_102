package com.example.demo.service;

import com.example.demo.entity.Warranty;
import java.util.List;

public interface WarrantyService {

    // Register a warranty for a user and product
    Warranty registerWarranty(Long userId, Long productId, Warranty warranty);

    // Get warranty by ID
    Warranty getWarrantyById(Long warrantyId);

    // List warranties of a user
    List<Warranty> getWarrantiesByUser(Long userId);
}
