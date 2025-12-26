package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    public AlertScheduleController(AlertScheduleService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertSchedule create(
            @PathVariable Long warrantyId,
            @RequestBody AlertSchedule schedule) {
        return service.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> getAll(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
