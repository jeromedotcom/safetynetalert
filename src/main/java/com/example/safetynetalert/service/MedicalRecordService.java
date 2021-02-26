package com.example.safetynetalert.service;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public void saveMedicalRecords(List<MedicalRecord> medicalRecords) {
        medicalRecordRepository.saveAll(medicalRecords);
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord getMedicalRecordFromLastNameAndFirstName(String lastName, String firstName) {
        return medicalRecordRepository.findMedicalRecordByLastNameAndFirstName(lastName, firstName);
    }

    public void deleteMedicalRecordByLastNameAndFirstName(String lastName, String firstName) {
        medicalRecordRepository.deleteMedicalRecordByLastNameAndFirstName(lastName, firstName);
    }


}
