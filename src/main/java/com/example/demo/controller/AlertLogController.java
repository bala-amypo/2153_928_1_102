package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;

@RestController
@RequestMapping("/logs")
public class AlertLogController {

    private final AlertLogService service;

    public AlertLogController(AlertLogService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    public AlertLog add(@PathVariable Long warrantyId,
                        @RequestBody String message) {
        return service.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertLog> list(@PathVariable Long warrantyId) {
        return service.getLogs(warrantyId);
    }
}
