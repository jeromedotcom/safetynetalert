package com.example.safetynetalert.service;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.model.PersonInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = PersonInfoService.class)
@ActiveProfiles("test")
public class PersonInfoServiceTest {
    @MockBean
    PersonService personService;
    @MockBean
    MedicalRecordService medicalRecordService;
    @Autowired
    PersonInfoService personInfoService;



    @Test
    public void testGetAllInfoPerson() {
        Person person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAllergies(Collections.singletonList("aspirine"));
        medicalRecord.setMedications(Collections.singletonList("aspirine"));


        when(personService.getPersonFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(person);
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(medicalRecord);

        PersonInfo personInfo = personInfoService.getAllInfoPerson(person.getFirstName(), person.getLastName());

        verify(personService, times(1)).getPersonFromLastNameAndFirstName(anyString(), anyString());
        verify(medicalRecordService, times(1)).getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());

        assertEquals(medicalRecord.getAllergies(), personInfo.getAllergies());
        assertEquals(person.getLastName(), personInfo.getLastName());

    }

}
