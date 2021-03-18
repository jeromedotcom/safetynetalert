package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.service.ChildAlertService;
import com.example.safetynetalert.service.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ChildAlertServiceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonService personService;
    @Autowired
    ChildAlertService childAlertService;

    @Test
    public void testGetChildFromAddress_whenMultipleChildren() {
        /*mockMvc.perform(get("/childAlert?address=1509%20Culver%20St"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasItem("Boyd")));*/

        ChildAlertList childAlertList = childAlertService.getChildFromAddress("1509 Culver St");
        assertEquals(3, childAlertList.getOtherFamilyMembers().size());
        assertEquals(2, childAlertList.getChild().size());
    }

    @Test
    public void testGetChildFromAddress_whenZeroChildren() {
        ChildAlertList childAlertList = childAlertService.getChildFromAddress("29 15th St");
        assertEquals(1, childAlertList.getOtherFamilyMembers().size());
        assertEquals(0, childAlertList.getChild().size());
    }
}
