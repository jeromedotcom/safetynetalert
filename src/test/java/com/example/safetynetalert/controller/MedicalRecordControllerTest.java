package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.service.MedicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MedicalRecordController.class)
@ActiveProfiles("test")
public class MedicalRecordControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MedicalRecordService medicalRecordService;

    MedicalRecord medicalRecord;
    List<MedicalRecord> medicalRecordList;
    String medicalRecordJson;

    @BeforeEach
    void init() {

        List<String> allergiesList = new ArrayList<>();
        allergiesList.add("allergie1");
        allergiesList.add("allergie2");

        List<String> medicationsList = new ArrayList<>();
        medicationsList.add("medication1");
        medicationsList.add("medication2");

        medicalRecord = new MedicalRecord();
        medicalRecord.setMedications(medicationsList);
        medicalRecord.setBirthdate("01-01-2000");
        medicalRecord.setAllergies(allergiesList);
        medicalRecord.setFirstName("test");
        medicalRecord.setLastName("test");

        medicalRecordList = new ArrayList<>();
        medicalRecordList.add(medicalRecord);

        medicalRecordJson = "{\n" +
                "        \"firstName\": \"Eric\",\n" +
                "        \"lastName\": \"Cadigan\",\n" +
                "        \"birthdate\": \"01-01-2000\",\n" +
                "        \"allergies\": [\"aznol:350mg\", \"hydrapermazol:100mg\"],\n" +
                "        \"medications\": [\"aznol:350mg\", \"hydrapermazol:100mg\"]\n" +
                "    }";
    }

    @Test
    public void testCreateMedicalRecord() throws Exception {
        when(medicalRecordService.saveMedicalRecord(any(MedicalRecord.class))).thenReturn(medicalRecord);
        mockMvc.perform(post("/medicalRecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content(medicalRecordJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMedicalRecordFromLastNameAndFirstName() throws Exception {
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        mockMvc.perform(get("/medicalRecord/test/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMedicalRecordByLastNameAndFirstName() throws Exception {
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        when(medicalRecordService.saveMedicalRecord(any(MedicalRecord.class))).thenReturn(medicalRecord);
        mockMvc.perform(put("/medicalRecord/test/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(medicalRecordJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMedicalRecordByLastNameAndFirstName() throws Exception {
        //when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        mockMvc.perform(delete("/medicalRecord/test/test"))
                .andExpect(status().isOk());
    }
}
