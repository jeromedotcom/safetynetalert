package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.repository.MedicalRecordRepository;
import com.example.safetynetalert.service.MedicalRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedicalRecordServiceIT {
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Test
    public void testGetMedicalRecordFromLastNameAndFirstName(){
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName("Boyd", "John");
        assertEquals("03/06/1984", medicalRecord.getBirthdate());
    }
}
