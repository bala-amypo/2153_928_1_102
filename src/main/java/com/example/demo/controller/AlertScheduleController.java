package com.example.demo.controller;

import com.example.demo.dto.AlertScheduleDTO;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.impl.AlertScheduleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts/schedules")
public class AlertScheduleController {

    private final AlertScheduleServiceImpl service;

    public AlertScheduleController(AlertScheduleServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertSchedule create(
            @PathVariable Long warrantyId,
            @RequestBody AlertScheduleDTO dto) {

        AlertSchedule s = AlertSchedule.builder()
                .daysBeforeExpiry(dto.getDaysBeforeExpiry())
                .enabled(dto.getEnabled())
                .build();

        return service.createSchedule(warrantyId, s);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> list(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
