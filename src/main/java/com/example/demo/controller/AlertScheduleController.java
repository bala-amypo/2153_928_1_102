package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.impl.AlertScheduleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@Tag(name = "Alert Schedules")
public class AlertScheduleController {

    private final AlertScheduleServiceImpl scheduleService;

    public AlertScheduleController(AlertScheduleServiceImpl scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Create alert schedule")
    public AlertSchedule createSchedule(@PathVariable Long warrantyId,
                                        @RequestBody AlertSchedule schedule) {
        return scheduleService.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get schedules for warranty")
    public List<AlertSchedule> getSchedules(@PathVariable Long warrantyId) {
        return scheduleService.getSchedules(warrantyId);
    }
}
