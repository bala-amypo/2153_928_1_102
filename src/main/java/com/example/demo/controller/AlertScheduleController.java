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

    // Add a new alert schedule
    @PostMapping("/add")
    public AlertSchedule addSchedule(@Valid @RequestBody AlertSchedule schedule) {
        return service.saveSchedule(schedule);
    }

    // Get all alert schedules
    @GetMapping("/all")
    public List<AlertSchedule> getSchedules() {
        return service.getAllSchedules();
    }
}
