package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository repository;

    public AlertLogServiceImpl(AlertLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlertLog> getLogsByWarrantyId(Long warrantyId) {
        return repository.findByWarrantyId(warrantyId);
    }
}
