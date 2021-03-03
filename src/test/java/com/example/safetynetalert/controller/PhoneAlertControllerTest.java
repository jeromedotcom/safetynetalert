package com.example.safetynetalert.controller;

import com.example.safetynetalert.service.PhoneAlertService;
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

@WebMvcTest(controllers = PhoneAlertController.class)
@ActiveProfiles("test")
public class PhoneAlertControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PhoneAlertService phoneAlertService;

    @Test
    public void testPhoneAlert() throws Exception {
        when(phoneAlertService.phoneAlert(anyString())).thenReturn(anyList());
        mockMvc.perform(get("/phoneAlert?fireStation=1"))
                .andExpect(status().isOk());

    }
}
