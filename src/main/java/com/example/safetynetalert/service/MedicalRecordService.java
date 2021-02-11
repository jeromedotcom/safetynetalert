package com.example.safetynetalert.service;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public void save (Iterable<MedicalRecord> medicalRecords) {
        medicalRecordRepository.saveAll(medicalRecords);
    }

}
