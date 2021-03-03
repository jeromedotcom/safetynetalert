package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.FireList;
import com.example.safetynetalert.service.FireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FireController.class)
@ActiveProfiles("test")
public class FireControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    FireService fireService;

    @Test
    public void testGetPeopleWhenFire() throws Exception {
        when(fireService.getPeopleWhenFire(anyString())).thenReturn(any(FireList.class));
        mockMvc.perform(get("/fire?address=a"))
                .andExpect(status().isOk());
    }

}
