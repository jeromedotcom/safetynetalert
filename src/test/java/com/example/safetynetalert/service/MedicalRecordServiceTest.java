package com.example.safetynetalert.service;


import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.repository.MedicalRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MedicalRecordServiceTest {

    @MockBean
    MedicalRecordRepository medicalRecordRepository;
    @Autowired
    MedicalRecordService medicalRecordService;

    @Test
    public void saveMedicalRecords_ShouldUseMedicalRecordRepository() {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        medicalRecordService.saveMedicalRecords(medicalRecords);
        verify(medicalRecordRepository, times(1)).saveAll(medicalRecords);
    }

    @Test
    public void saveMedicalRecord_ShouldUseMedicalRecordRepository() {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecordService.saveMedicalRecord(medicalRecord);
        verify(medicalRecordRepository, times(1)).save(medicalRecord);

    }

    @Test
    public void getMedicalRecordFromLastNameAndFirstName_ShouldUseMedicalRecordRepository() {
        medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());
        verify(medicalRecordRepository, times(1)).findMedicalRecordByLastNameAndFirstName(anyString(), anyString());
    }

    @Test
    public void deleteMedicalRecordByLastNameAndFirstName_ShouldUseMedicalRecordRepository() {
        medicalRecordService.deleteMedicalRecordByLastNameAndFirstName(anyString(), anyString());
        verify(medicalRecordRepository, times(1)).deleteMedicalRecordByLastNameAndFirstName(anyString(), anyString());
    }
}
