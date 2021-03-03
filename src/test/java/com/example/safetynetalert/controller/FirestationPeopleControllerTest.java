package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.FirestationPeopleList;
import com.example.safetynetalert.service.FirestationPeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationPeopleController.class)
@ActiveProfiles("test")
public class FirestationPeopleControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    FirestationPeopleService firestationPeopleService;

    @Test
    public void testGetPeopleWhenFire() throws Exception {
        when(firestationPeopleService.getPeopleFromFirestationNumber(anyString())).thenReturn(any(FirestationPeopleList.class));
        mockMvc.perform(get("/firestation?stationNumber=1"))
                .andExpect(status().isOk());
    }

}
