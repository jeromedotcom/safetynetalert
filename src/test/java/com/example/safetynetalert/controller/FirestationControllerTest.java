package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.service.FirestationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationController.class)
@ActiveProfiles("test")
public class FirestationControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    FirestationService firestationService;

    Firestation firestation;
    String firestationJson;
    List<Firestation> firestationList;

    @BeforeEach
    void init() {
        firestation = new Firestation();
        firestation.setAddress("rue de Paris");
        firestation.setStation("1");

        firestationJson ="{\n" +
                "        \"address\": \"rue de Paris\",\n" +
                "        \"station\": \"1\"\n" +
                "    }";

        firestationList = new ArrayList<>();
        firestationList.add(firestation);
    }

    @Test
    public void testCreateFirestation() throws Exception {
        when(firestationService.saveFirestation(any(Firestation.class))).thenReturn(firestation);
        mockMvc.perform(post("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(firestationJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFirestationsFromStation() throws Exception {
        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestationList);
        mockMvc.perform(get("/firestation/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFirestationsFromAddress() throws Exception {
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestationList);
        mockMvc.perform(get("/firestation/address/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateFirestation() throws Exception {
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestationList);
        mockMvc.perform(put("/firestation/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(firestationJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteFirestationByStation() throws Exception {
        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestationList);
        mockMvc.perform(delete("/firestation/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteFirestationByAddress() throws Exception {
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestationList);
        mockMvc.perform(delete("/firestation/address/test"))
                .andExpect(status().isOk());
    }



}
