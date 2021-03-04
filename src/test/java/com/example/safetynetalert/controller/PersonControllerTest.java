package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@SpringBootTest
@AutoConfigureMockMvc*/
@WebMvcTest(controllers = PersonController.class)
@ActiveProfiles("test")
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    Person person;
    List<Person> personList;
    String personJson;


    @BeforeEach
    public void init() {
        person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");

        personList = new ArrayList<>();
        personList.add(person);

        personJson = "{\n" +
                "        \"id\": 23,\n" +
                "        \"firstName\": \"Eric\",\n" +
                "        \"lastName\": \"Cadigan\",\n" +
                "        \"address\": \"951 LoneTree Rd\",\n" +
                "        \"city\": \"Culver\",\n" +
                "        \"zip\": \"97451\",\n" +
                "        \"phone\": \"841-874-7458\",\n" +
                "        \"email\": \"gramps@email.com\"\n" +
                "    }";
    }

    @Test
    public void testCreatePerson () throws Exception {
        when(personService.savePerson(any(Person.class))).thenReturn(person);
        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPersons () throws Exception {
        when(personService.getPersons()).thenReturn(personList);
        mockMvc.perform(get("/persons")).
                andExpect(status().isOk());
    }

    @Test
    public void testGetPersonFromLastNameAndFirstName () throws Exception {
        when(personService.getPersonFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(person);
        mockMvc.perform(get("/person/test/test"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePerson () throws Exception {
        when(personService.getPersonFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(person);
        mockMvc.perform(put("/person/test/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePersonFromLastNameAndFirstName () throws Exception {
        when(personService.getPersonFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(person);
        mockMvc.perform(delete("/person/test/test"))
                .andExpect(status().isOk());
    }

}
