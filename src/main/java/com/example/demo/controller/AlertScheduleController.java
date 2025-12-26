package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.impl.AlertScheduleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleServiceImpl service;

    public AlertScheduleController(AlertScheduleServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertSchedule createSchedule(@PathVariable Long warrantyId,
                                        @RequestBody AlertSchedule schedule) {
        return service.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> getSchedules(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
