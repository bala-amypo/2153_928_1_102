package com.example.demo.service;

import com.example.demo.entity.Warranty;
import java.util.List;

public interface WarrantyService {

    Warranty registerWarranty(Warranty warranty);

    Warranty getWarrantyById(Long id);

    List<Warranty> getWarrantiesByUser(Long userId);
}
