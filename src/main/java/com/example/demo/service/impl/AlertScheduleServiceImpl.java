package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;

import java.util.List;

public class AlertScheduleServiceImpl {

    private final AlertScheduleRepository alertScheduleRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertScheduleServiceImpl(AlertScheduleRepository alertScheduleRepository,
                                    WarrantyRepository warrantyRepository) {
        this.alertScheduleRepository = alertScheduleRepository;
        this.warrantyRepository = warrantyRepository;
    }

    public AlertSchedule createSchedule(Long warrantyId,
                                        AlertSchedule schedule) {

        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warranty not found"));

        if (schedule.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry");
        }

        schedule.setWarranty(warranty);

        return alertScheduleRepository.save(schedule);
    }

    public List<AlertSchedule> getSchedules(Long warrantyId) {

        warrantyRepository.findById(warrantyId)
                .orElseThrow(() ->
                        new RuntimeException("Warranty not found"));

        return alertScheduleRepository.findByWarrantyId(warrantyId);
    }
}
