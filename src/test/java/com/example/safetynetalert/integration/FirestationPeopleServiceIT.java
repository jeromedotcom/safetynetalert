package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.FirestationPeopleList;
import com.example.safetynetalert.service.FirestationPeopleService;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationPeopleServiceIT {
    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;
    @Autowired
    FirestationPeopleService firestationPeopleService;

    @Test
    public void testGetPeopleFromFirestationNumber() {
        FirestationPeopleList firestationPeopleList = firestationPeopleService.getPeopleFromFirestationNumber("1");
        assertEquals(5, firestationPeopleList.getAdult());
        assertEquals(1, firestationPeopleList.getChild());
    }
}
