package com.example.safetynetalert.integration;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.repository.PersonRepository;
import com.example.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonServiceIT {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    @Test
    public void testGetEmailsFromCity() {
        List emails = personService.getEmailsFromCity("Culver");
        assertEquals(15, emails.size());
    }

    @Test
    public void testGetPersonFromLastNameAndFirstName() {
        Person person = personService.getPersonFromLastNameAndFirstName("Boyd", "John");
        assertEquals("jaboyd@email.com", person.getEmail());
    }
}
