package com.example.app1.service;

import com.example.app1.dto.HealthRecordDto;

public interface HealthRecordService {
    String createHealthRecord(HealthRecordDto healthRecordDto);
    HealthRecordDto getHealthRecord(Long id);
    String updateHealthRecord(Long id, HealthRecordDto healthRecordDto);
    String deleteHealthRecord(Long id);
}
