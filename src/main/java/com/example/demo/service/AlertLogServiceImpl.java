package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional   // ✅ Transaction added here
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository alertLogRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertLogServiceImpl(AlertLogRepository alertLogRepository,
                               WarrantyRepository warrantyRepository) {
        this.alertLogRepository = alertLogRepository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public AlertLog addLog(Long warrantyId, String message) {

        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        AlertLog log = AlertLog.builder()
                .warranty(warranty)
                .message(message)
                .build();

        return alertLogRepository.save(log);
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return alertLogRepository.findByWarrantyId(warrantyId);
    }
}
