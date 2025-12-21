package com.example.demo.service;

import com.example.demo.entity.AlertSchedule;

import java.util.List;

public interface AlertScheduleService {

    // REQUIRED by question
    AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule);

    // REQUIRED by question
    List<AlertSchedule> getSchedules(Long warrantyId);
}
