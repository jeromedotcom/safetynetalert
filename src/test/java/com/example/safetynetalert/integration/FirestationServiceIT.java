package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.repository.FirestationRepository;
import com.example.safetynetalert.service.FirestationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationServiceIT {

    @Autowired
    FirestationRepository firestationRepository;
    @Autowired
    FirestationService firestationService;

    @Test
    public void testGetFirestationsFromStationNumber() {
        List<Firestation> f = (List<Firestation>) firestationService.getFirestationsFromStationNumber("1");
        assertEquals("644 Gershwin Cir", f.get(0).getAddress());
    }

}
