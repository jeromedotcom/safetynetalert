package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.service.PersonInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonInfoController.class)
@ActiveProfiles("test")
public class PersonInfoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PersonInfoService personInfoService;

    @Test
    public void testGetAllInfoPerson() throws Exception {
        when(personInfoService.getAllInfoPerson(anyString(), anyString())).thenReturn(eq(any(PersonInfo.class)));
        mockMvc.perform(get("/personInfo?firstName=a&lastname=b"))
                .andExpect(status().isOk());
    }

}
