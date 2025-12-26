package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository alertScheduleRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertScheduleServiceImpl(AlertScheduleRepository alertScheduleRepository,
                                    WarrantyRepository warrantyRepository){
        this.alertScheduleRepository = alertScheduleRepository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule){
        warrantyRepository.findById(warrantyId).orElseThrow(() -> new RuntimeException("Warranty not found"));
        return alertScheduleRepository.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId){
        warrantyRepository.findById(warrantyId).orElseThrow(() -> new RuntimeException("Warranty not found"));
        return alertScheduleRepository.findByWarrantyId(warrantyId);
    }
}
