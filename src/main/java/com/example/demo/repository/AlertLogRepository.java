package com.example.demo.repository;

import com.example.demo.entity.AlertLog;
import java.util.List;

public interface AlertLogRepository {
    AlertLog save(AlertLog log);
    List<AlertLog> findByWarrantyId(Long warrantyId);
}
