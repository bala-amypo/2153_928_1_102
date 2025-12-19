package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.service.AlertScheduleService;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {
    private final AlertScheduleRepository repo;
    public AlertScheduleServiceImpl(AlertScheduleRepository repo){ this.repo = repo; }

    @Override
    public AlertSchedule saveSchedule(AlertSchedule s){ return repo.save(s); }

    @Override
    public List<AlertSchedule> getAllSchedules(){ return repo.findAll(); }

    
}
