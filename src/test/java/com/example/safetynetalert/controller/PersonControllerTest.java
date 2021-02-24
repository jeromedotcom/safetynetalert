package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.MergedObjectService;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*@SpringBootTest
@AutoConfigureMockMvc*/
@WebMvcTest(controllers = PersonController.class)
@ActiveProfiles("test")
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;
    /*@MockBean
    private FirestationService firestationService;
    @MockBean
    private MedicalRecordService medicalRecordService;
    @MockBean
    private MergedObjectService mergedObjectService;*/

    @Test
    public void testGetPersons () throws Exception {
        /*Person person = new Person();
        person.setLastName("myLastName");
        person.setFirstName("myFirstName");
        person.setAddress("myAddress");
        person.setCity("myCity");
        person.setPhone("myPhone");
        person.setEmail("myEmail");
        person.setZip("myZip");
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personService.getPersons()).thenReturn(personList);*/
        mockMvc.perform(get("/persons")).
                andExpect(status().isOk());
    }

    @Test
    public void testCreatePerson () throws Exception {
        mockMvc.perform(post("/person")).andExpect(status().isOk());
    }
}
