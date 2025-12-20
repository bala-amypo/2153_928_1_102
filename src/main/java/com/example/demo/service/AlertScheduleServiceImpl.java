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

    private final AlertScheduleRepository alertRepo;
    private final WarrantyRepository warrantyRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository alertRepo,
                                    WarrantyRepository warrantyRepo) {
        this.alertRepo = alertRepo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertSchedule saveSchedule(AlertSchedule s) {

        Long warrantyId = s.getWarranty().getId();

        Warranty warranty = warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        s.setWarranty(warranty);

        return alertRepo.save(s);
    }

    @Override
    public List<AlertSchedule> getAllSchedules() {
        return alertRepo.findAll();
    }
}
