package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.service.ChildAlertService;
import org.junit.jupiter.api.Disabled;
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

@WebMvcTest(controllers = ChildAlertController.class)
@ActiveProfiles("test")
public class ChildAlertControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ChildAlertService childAlertService;

    @Disabled
    @Test
    public void testPhoneAlert() throws Exception {
        when(childAlertService.getChildFromAddress(anyString())).thenReturn(any(ChildAlertList.class));
        mockMvc.perform(get("/childAlert?address=a"))
                .andExpect(status().isOk());

    }
}
