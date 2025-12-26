package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;

import java.util.List;

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
        warrantyRepository.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        AlertLog log = AlertLog.builder()
                .message(message)
                .build();

        log.prePersist();
        return alertLogRepository.save(log);
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        warrantyRepository.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        return alertLogRepository.findByWarrantyId(warrantyId);
    }
}
