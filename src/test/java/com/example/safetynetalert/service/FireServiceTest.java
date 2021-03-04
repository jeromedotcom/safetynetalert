package com.example.safetynetalert.service;

import com.example.safetynetalert.model.FireList;
import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = FireService.class)
@ActiveProfiles("test")
public class FireServiceTest {
    @MockBean
    PersonService personService;
    @MockBean
    FirestationService firestationService;
    @MockBean
    MedicalRecordService medicalRecordService;

    @Autowired
    FireService fireService;

    @Test
    public void testGetPeopleWhenFire() {

        Person person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAllergies(Collections.singletonList("aspirine"));
        medicalRecord.setMedications(Collections.singletonList("aspirine"));
        Firestation firestation = new Firestation();
        firestation.setStation("1");
        firestation.setAddress("a");
        List firestations = new ArrayList<>();
        firestations.add(firestation);

        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
        when(personService.getAge(anyString(), anyString())).thenReturn(10);
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestations);

        FireList fireList = fireService.getPeopleWhenFire(anyString());

        verify(personService, times(1)).getPersonFromAddress(anyString());
        verify(medicalRecordService, times(1)).getMedicalRecordFromLastNameAndFirstName(anyString(),anyString());
        verify(firestationService, times(1)).getFirestationFromAddress(anyString());

        assertEquals(10, fireList.getFirePeopleList().get(0).getAge());
    }
}
