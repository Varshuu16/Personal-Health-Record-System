package com.example.app1.controller;

import com.example.app1.dto.HealthRecordDto;
import com.example.app1.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healthrecord")
@CrossOrigin(origins = "*")
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;

    @PostMapping("/create")
    public String createHealthRecord(@RequestBody HealthRecordDto healthRecordDto) {
        return healthRecordService.createHealthRecord(healthRecordDto);
    }

    @GetMapping("/get/{id}")
    public HealthRecordDto getHealthRecord(@PathVariable Long id) {
        return healthRecordService.getHealthRecord(id);
    }

    @PutMapping("/update/{id}")
    public String updateHealthRecord(@PathVariable Long id, @RequestBody HealthRecordDto healthRecordDto) {
        return healthRecordService.updateHealthRecord(id, healthRecordDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHealthRecord(@PathVariable Long id) {
        return healthRecordService.deleteHealthRecord(id);
    }
}
