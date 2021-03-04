package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = PhoneAlertService.class)
@ActiveProfiles("test")
public class PhoneAlertServiceTest {
    @MockBean
    FirestationService firestationService;
    @MockBean
    PersonService personService;
    @Autowired
    PhoneAlertService phoneAlertService;

    List<Firestation> firestations = new ArrayList<>();
    Firestation f1 = new Firestation();
    Firestation f2 = new Firestation();

    List<Person> persons = new ArrayList<>();
    Person p1 = new Person();
    Person p2 = new Person();

    @BeforeEach
    public void init() {

    f1.setStation("1");
    f1.setAddress("rue de Paris");
    f2.setStation("2");
    f2.setAddress("rue de Paris");
    firestations.add(f1);
    firestations.add(f2);

    p1.setPhone("123");
    p1.setAddress("rue de Paris");
    p2.setPhone("123");
    p2.setAddress("rue de Lille");
    persons.add(p1);
    persons.add(p2);

    }

    @Test
    public void testPhoneAlert() {
        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestations);
        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);

        List<String> result = phoneAlertService.phoneAlert(anyString());

        verify(firestationService, times(1)).getFirestationsFromStationNumber(anyString());
        verify(personService, times(2)).getPersonFromAddress(anyString());

        List<String> expectedPhoneList = new ArrayList<>();
        expectedPhoneList.add("123");
        assertEquals(expectedPhoneList, result);
    }


}
