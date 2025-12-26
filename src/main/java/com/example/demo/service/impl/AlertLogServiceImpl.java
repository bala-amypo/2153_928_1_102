// src/main/java/com/example/demo/service/impl/AlertLogServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AlertLogServiceImpl implements AlertLogService {
    
    @Autowired
    private AlertLogRepository logRepository;
    
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    public AlertLogServiceImpl(AlertLogRepository logRepository,
                              WarrantyRepository warrantyRepository) {
        this.logRepository = logRepository;
        this.warrantyRepository = warrantyRepository;
    }
    
    @Override
    public AlertLog addLog(Long warrantyId, String message) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
            .orElseThrow(() -> new RuntimeException("Warranty not found with id: " + warrantyId));
        
        AlertLog log = AlertLog.builder()
            .warranty(warranty)
            .message(message)
            .build();
        
        return logRepository.save(log);
    }
    
    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        warrantyRepository.findById(warrantyId)
            .orElseThrow(() -> new RuntimeException("Warranty not found with id: " + warrantyId));
        
        return logRepository.findByWarrantyId(warrantyId);
    }
}