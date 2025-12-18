package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {
    private final AlertScheduleService service;
    public AlertScheduleController(AlertScheduleService service){ this.service = service; }

    @PostMapping("/add")
    public AlertSchedule addSchedule(@RequestBody AlertSchedule s){ return service.saveSchedule(s); }

    @GetMapping("/all")
    public List<AlertSchedule> getSchedules(){ return service.getAllSchedules(); }

    @GetMapping("/{id}")
    public AlertSchedule getSchedule(@PathVariable Long id){ return service.getScheduleById(id); }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id){
        service.deleteSchedule(id);
        return "Deleted successfully";
    }
}
