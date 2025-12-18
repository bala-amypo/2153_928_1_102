package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;

@RestController
@RequestMapping("/alerts")
public class AlertLogController {
    private final AlertLogService service;
    public AlertLogController(AlertLogService service){ this.service = service; }

    @PostMapping("/add")
    public AlertLog addAlert(@RequestBody AlertLog log){ return service.saveAlert(log); }

    @GetMapping("/all")
    public List<AlertLog> getAlerts(){ return service.getAllAlerts(); }

    @GetMapping("/{id}")
    public AlertLog getAlert(@PathVariable Long id){ return service.getAlertById(id); }

    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable Long id){
        service.deleteAlert(id);
        return "Deleted successfully";
    }
}
