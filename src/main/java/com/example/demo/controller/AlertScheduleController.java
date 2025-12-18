package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    public AlertScheduleController(AlertScheduleService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertSchedule create(@PathVariable Long warrantyId,
                                @RequestBody AlertSchedule schedule) {
        return service.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> list(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
