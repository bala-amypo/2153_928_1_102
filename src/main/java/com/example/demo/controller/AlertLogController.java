package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AlertLogController {

    private final AlertLogService service;

    public AlertLogController(AlertLogService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertLog add(
            @PathVariable Long warrantyId,
            @RequestBody String message) {
        return service.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertLog> getAll(@PathVariable Long warrantyId) {
        return service.getLogs(warrantyId);
    }
}
