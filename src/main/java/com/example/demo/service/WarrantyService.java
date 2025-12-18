package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Warranty;

public interface WarrantyService {
    Warranty registerWarranty(Long userId, Long productId, Warranty warranty);
    Warranty getWarranty(Long warrantyId);
    List<Warranty> getUserWarranties(Long userId);
}
