package com.example.app1.serviceimpl;

import com.example.app1.dto.HealthRecordDto;
import com.example.app1.entity.HealthRecord;
import com.example.app1.repository.HealthRecordRepository;
import com.example.app1.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Override
    public String createHealthRecord(HealthRecordDto healthRecordDto) {
        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setDate(healthRecordDto.getDate());
        healthRecord.setDescription(healthRecordDto.getDescription());
        healthRecord.setFilePath(healthRecordDto.getFilePath());
        healthRecordRepository.save(healthRecord);
        return "Health record created successfully";
    }

    @Override
    public HealthRecordDto getHealthRecord(Long id) {
        Optional<HealthRecord> optionalHealthRecord = healthRecordRepository.findById(id);
        if (optionalHealthRecord.isPresent()) {
            HealthRecord healthRecord = optionalHealthRecord.get();
            HealthRecordDto healthRecordDto = new HealthRecordDto();
            healthRecordDto.setRecordID(healthRecord.getRecordID());
            healthRecordDto.setDate(healthRecord.getDate());
            healthRecordDto.setDescription(healthRecord.getDescription());
            healthRecordDto.setFilePath(healthRecord.getFilePath());
            return healthRecordDto;
        } else {
            throw new RuntimeException("Health record not found");
        }
    }

    @Override
    public String updateHealthRecord(Long id, HealthRecordDto healthRecordDto) {
        Optional<HealthRecord> optionalHealthRecord = healthRecordRepository.findById(id);
        if (optionalHealthRecord.isPresent()) {
            HealthRecord healthRecord = optionalHealthRecord.get();
            healthRecord.setDate(healthRecordDto.getDate());
            healthRecord.setDescription(healthRecordDto.getDescription());
            healthRecord.setFilePath(healthRecordDto.getFilePath());
            healthRecordRepository.save(healthRecord);
            return "Health record updated successfully";
        } else {
            return "Health record not found";
        }
    }

    @Override
    public String deleteHealthRecord(Long id) {
        if (healthRecordRepository.existsById(id)) {
            healthRecordRepository.deleteById(id);
            return "Health record deleted successfully";
        } else {
            return "Health record not found";
        }
    }
}
