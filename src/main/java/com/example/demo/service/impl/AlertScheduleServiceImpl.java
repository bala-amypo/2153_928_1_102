// src/main/java/com/example/demo/service/impl/AlertScheduleServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AlertScheduleServiceImpl implements AlertScheduleService {
    
    @Autowired
    private AlertScheduleRepository scheduleRepository;
    
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    public AlertScheduleServiceImpl(AlertScheduleRepository scheduleRepository,
                                   WarrantyRepository warrantyRepository) {
        this.scheduleRepository = scheduleRepository;
        this.warrantyRepository = warrantyRepository;
    }
    
    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
            .orElseThrow(() -> new RuntimeException("Warranty not found with id: " + warrantyId));
        
        if (schedule.getDaysBeforeExpiry() == null || schedule.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry must be non-negative");
        }
        
        schedule.setWarranty(warranty);
        return scheduleRepository.save(schedule);
    }
    
    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        warrantyRepository.findById(warrantyId)
            .orElseThrow(() -> new RuntimeException("Warranty not found with id: " + warrantyId));
        
        return scheduleRepository.findByWarrantyId(warrantyId);
    }
}