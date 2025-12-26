package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository repo;
    private final WarrantyRepository warrantyRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository r, WarrantyRepository w) {
        this.repo = r;
        this.warrantyRepo = w;
    }

    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule s) {
        if (s.getDaysBeforeExpiry() < 0)
            throw new IllegalArgumentException("daysBeforeExpiry invalid");

        Warranty w = warrantyRepo.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        s.setWarranty(w);
        return repo.save(s);
    }

    public List<AlertSchedule> getSchedules(Long warrantyId) {
        warrantyRepo.findById(warrantyId).orElseThrow(RuntimeException::new);
        return repo.findByWarrantyId(warrantyId);
    }
}
