package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertSchedule;

public interface AlertScheduleService {
    AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule);
    List<AlertSchedule> getSchedules(Long warrantyId);
}
