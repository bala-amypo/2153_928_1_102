package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    public AlertScheduleController(AlertScheduleService service) {
        this.service = service;
    }

    // Create alert schedule for a warranty
    @PostMapping("/{warrantyId}")
    public AlertSchedule createSchedule(
            @PathVariable Long warrantyId,
            @Valid @RequestBody AlertSchedule schedule) {
        return service.createSchedule(warrantyId, schedule);
    }

    // Get alert schedules by warrantyId
    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> getSchedules(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
