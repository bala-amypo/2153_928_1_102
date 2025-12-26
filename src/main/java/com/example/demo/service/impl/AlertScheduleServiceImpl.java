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

    public AlertScheduleServiceImpl(AlertScheduleRepository repo,
                                    WarrantyRepository warrantyRepo) {
        this.repo = repo;
        this.warrantyRepo = warrantyRepo;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {

        Warranty warranty = warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        schedule.setWarranty(warranty);
        schedule.setSent(false);

        return repo.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        return repo.findByWarrantyId(warrantyId);
    }
}
