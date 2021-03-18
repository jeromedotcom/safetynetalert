package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.PersonInfoService;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonInfoServiceIT {

    @Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    PersonInfoService personInfoService;

    @Test
    public void testGetAllInfoPerson() {
        PersonInfo personInfo = personInfoService.getAllInfoPerson("Peter", "Duncan");
        assertEquals(20, personInfo.getAge());
    }
}
