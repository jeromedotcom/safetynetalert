package com.example.safetynetalert.service;

import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(controllers = ChildAlertService.class)
@ActiveProfiles("test")
public class ChildAlertServiceTest {
    @MockBean
    PersonService personService;
    @Autowired
    ChildAlertService childAlertService;

    @Test
    public void testGetChildFromAddress() {
        Person person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");
        List<Person> persons = new ArrayList<>();
        persons.add(person);

        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
        when(personService.getAge(anyString(), anyString())).thenReturn(10);

        ChildAlertList childAlertList = childAlertService.getChildFromAddress(anyString());

        verify(personService, times(1)).getPersonFromAddress(anyString());
        verify(personService, times(1)).getAge(anyString(), anyString());
        assertEquals(1, childAlertList.getChild().size());
    }
}
