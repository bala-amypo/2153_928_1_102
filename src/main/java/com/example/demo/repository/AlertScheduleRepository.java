package com.example.demo.repository;

import com.example.demo.entity.AlertSchedule;
import java.util.List;

public interface AlertScheduleRepository {
    AlertSchedule save(AlertSchedule schedule);
    List<AlertSchedule> findByWarrantyId(Long warrantyId);
}
