package com.example.safetynetalert.integration;

import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.FloodService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FloodServiceIT {
    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    FloodService floodService;

    @Test
    public void testGetPeopleWhenFloodFromStationNumber_whenOneStationNumber() {
        List floodPeopleList = floodService.getPeopleWhenFloodFromStationNumber(Collections.singletonList("1"));
        assertEquals(3, floodPeopleList.size());
    }

    @Test
    public void testGetPeopleWhenFloodFromStationNumber_whenMultipleStationNumber() {
        List stationNumbers = new ArrayList();
        stationNumbers.add("1");
        stationNumbers.add("2");
        System.out.println(stationNumbers);
        List floodPeopleList = floodService.getPeopleWhenFloodFromStationNumber(stationNumbers);
        assertEquals(6, floodPeopleList.size());
    }
}
