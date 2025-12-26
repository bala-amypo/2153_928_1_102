package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.*;

import java.util.List;

public class AlertScheduleServiceImpl {

    private final AlertScheduleRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository r, WarrantyRepository w) {
        this.repo = r;
        this.warrantyRepo = w;
    }

    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule s) {
        Warranty w = warrantyRepo.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        if (s.getDaysBeforeExpiry() < 0)
            throw new IllegalArgumentException("daysBeforeExpiry invalid");

        return repo.save(s);
    }

    public List<AlertSchedule> getSchedules(Long warrantyId) {
        warrantyRepo.findById(warrantyId).orElseThrow(RuntimeException::new);
        return repo.findByWarrantyId(warrantyId);
    }
}
