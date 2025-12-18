package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.service.AlertScheduleService;
import com.example.demo.repository.WarrantyRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    @Autowired
    private WarrantyRepository warrantyRepository; // To fetch existing warranty

    public AlertScheduleController(AlertScheduleService service){
        this.service = service;
    }

    // Add schedule (fetch Warranty from DB first)
    @PostMapping("/add")
    public AlertSchedule addSchedule(@RequestBody AlertSchedule schedule){
        // Fetch the existing Warranty using only the ID
        Warranty warranty = warrantyRepository.findById(schedule.getWarranty().getId())
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        schedule.setWarranty(warranty);

        return service.saveSchedule(schedule);
    }

    @GetMapping("/all")
    public List<AlertSchedule> getSchedules(){
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public AlertSchedule getSchedule(@PathVariable Long id){
        return service.getScheduleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id){
        service.deleteSchedule(id);
        return "Deleted successfully";
    }
}
