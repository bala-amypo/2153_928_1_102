package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;

import java.util.List;

public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository alertScheduleRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertScheduleServiceImpl(AlertScheduleRepository alertScheduleRepository,
                                    WarrantyRepository warrantyRepository) {
        this.alertScheduleRepository = alertScheduleRepository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {

        warrantyRepository.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        if (schedule.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry invalid");
        }

        return alertScheduleRepository.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        warrantyRepository.findById(warrantyId)
                .orElseThrow(RuntimeException::new);

        return alertScheduleRepository.findByWarrantyId(warrantyId);
    }
}
