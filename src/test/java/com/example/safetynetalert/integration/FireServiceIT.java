package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.FireList;
import com.example.safetynetalert.service.FireService;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class FireServiceIT {
    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    FireService fireService;

    @Test
    public void testGetPeopleWhenFire_whenOnePerson() {
        FireList fireList = fireService.getPeopleWhenFire("29 15th St");
        assertEquals(1, fireList.getFirePeopleList().size());
    }

    @Test
    public void testGetPeopleWhenFire_whenMultiplePerson() {
        FireList fireList = fireService.getPeopleWhenFire("1509 Culver St");
        assertEquals(5, fireList.getFirePeopleList().size());
    }

}
