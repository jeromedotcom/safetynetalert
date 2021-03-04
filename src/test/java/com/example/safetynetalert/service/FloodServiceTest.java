package com.example.safetynetalert.service;

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

@WebMvcTest(controllers = FloodService.class)
@ActiveProfiles("test")
public class FloodServiceTest {
    @MockBean
    PersonService personService;
    @MockBean
    FirestationService firestationService;
    @MockBean
    MedicalRecordService medicalRecordService;
    @Autowired
    FloodService floodService;

    @Test
    public void testGetPeopleWhenFloodFromStationNumber() {
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
        List<String> stationNumbers = new ArrayList<>();
        stationNumbers.add("1");

        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestations);
        when(personService.getAge(anyString(), anyString())).thenReturn(10);
        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);

        List floodPeople = floodService.getPeopleWhenFloodFromStationNumber(stationNumbers);

        verify(firestationService, times(1)).getFirestationsFromStationNumber(anyString());
        verify(personService, times(1)).getAge(anyString(), anyString());
        verify(personService, times(1)).getPersonFromAddress(anyString());
        verify(medicalRecordService, times(2)).getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());

        assertEquals(1, floodPeople.size());
    }

}
