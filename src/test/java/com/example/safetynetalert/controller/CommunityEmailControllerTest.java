package com.example.safetynetalert.controller;

import com.example.safetynetalert.service.PersonService;
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

@WebMvcTest(controllers = CommunityEmailController.class)
@ActiveProfiles("test")
public class CommunityEmailControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PersonService personService;

    @Test
    public void testGetPeopleWhenFire() throws Exception {
        when(personService.getEmailsFromCity(anyString())).thenReturn(anyList());
        mockMvc.perform(get("/communityEmail?city=a"))
                .andExpect(status().isOk());
    }

}
