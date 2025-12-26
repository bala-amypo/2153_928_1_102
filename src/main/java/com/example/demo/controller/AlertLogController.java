package com.example.demo.controller;

import com.example.demo.dto.AlertLogDTO;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.impl.AlertLogServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts/logs")
public class AlertLogController {

    private final AlertLogServiceImpl service;

    public AlertLogController(AlertLogServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertLog addLog(
            @PathVariable Long warrantyId,
            @RequestBody AlertLogDTO dto) {

        return service.addLog(warrantyId, dto.getMessage());
    }

    @GetMapping("/{warrantyId}")
    public List<AlertLog> getLogs(@PathVariable Long warrantyId) {
        return service.getLogs(warrantyId);
    }
}
