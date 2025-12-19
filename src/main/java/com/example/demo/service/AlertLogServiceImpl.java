package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.AlertLog;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.service.AlertLogService;

@Service
public class AlertLogServiceImpl implements AlertLogService {
    private final AlertLogRepository repo;
    public AlertLogServiceImpl(AlertLogRepository repo){ this.repo = repo; }

    @Override
    public AlertLog saveAlert(AlertLog log){ return repo.save(log); }

    @Override
    public List<AlertLog> getAllAlerts(){ return repo.findAll(); }

   
}
