package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertLogServiceImpl(AlertLogRepository r, WarrantyRepository w) {
        this.repo = r;
        this.warrantyRepo = w;
    }

    public AlertLog addLog(Long warrantyId, String msg) {
        Warranty w = warrantyRepo.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        AlertLog log = AlertLog.builder()
                .message(msg)
                .warranty(w)
                .build();

        return repo.save(log);
    }

    public List<AlertLog> getLogs(Long warrantyId) {
        warrantyRepo.findById(warrantyId).orElseThrow(RuntimeException::new);
        return repo.findByWarrantyId(warrantyId);
    }
}
