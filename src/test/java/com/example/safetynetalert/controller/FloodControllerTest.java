package com.example.safetynetalert.controller;

import com.example.safetynetalert.service.FloodService;
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

@WebMvcTest(controllers = FloodController.class)
@ActiveProfiles("test")
public class FloodControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    FloodService floodService;

    @Test
    public void testPhoneAlert() throws Exception {
        when(floodService.getPeopleWhenFloodFromStationNumber(anyList())).thenReturn(anyList());
        mockMvc.perform(get("/flood/stations?stations=1,2"))
                .andExpect(status().isOk());

    }
}
