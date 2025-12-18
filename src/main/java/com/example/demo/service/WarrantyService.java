package com.example.demo.service;

import com.example.demo.entity.Warranty;
import java.util.List;

public interface WarrantyService {
    Warranty saveWarranty(Warranty warranty);
    List<Warranty> getAllWarranties();
    Warranty getWarrantyById(Long id);
    void deleteWarranty(Long id);
}
