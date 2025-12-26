package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.repository.*;

import java.util.List;

public class AlertLogServiceImpl {

    private final AlertLogRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertLogServiceImpl(AlertLogRepository r, WarrantyRepository w) {
        this.repo = r;
        this.warrantyRepo = w;
    }

    public AlertLog addLog(Long warrantyId, String msg) {
        warrantyRepo.findById(warrantyId).orElseThrow(RuntimeException::new);
        AlertLog l = AlertLog.builder().message(msg).build();
        l.prePersist();
        return repo.save(l);
    }

    public List<AlertLog> getLogs(Long warrantyId) {
        warrantyRepo.findById(warrantyId).orElseThrow(RuntimeException::new);
        return repo.findByWarrantyId(warrantyId);
    }
}
