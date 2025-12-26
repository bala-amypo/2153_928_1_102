package com.example.demo.service;

import com.example.demo.entity.AlertSchedule;
import java.util.List;


@Service 
public interface AlertScheduleService {
    AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule);
    List<AlertSchedule> getSchedules(Long warrantyId);
}
