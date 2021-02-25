package com.example.safetynetalert.service;

import com.example.safetynetalert.controller.FirestationController;
import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = PersonService.class)
@ActiveProfiles("test")
public class PersonServiceTest {

    @MockBean
    PersonRepository personRepository;
    @Autowired
    PersonService personService ;


    @Test
    public void savePerson_ShouldUsePersonRepository() {
        Person person = new Person();
        personService.savePerson(person);
        verify(personRepository, times(1)).save(person);
    }

    @Test
    public void savePersons_ShouldUsePersonRepository() {
        List<Person> persons = new ArrayList<>();
        personService.savePersons(anyList());
        verify(personRepository, times(1)).saveAll(anyList());
    }

    @Test
    public void getPersons_ShouldUsePersonRepository() {
        /*List<Person> persons = new ArrayList<>();
        Person p = new Person();
        p.setPhone("phone");
        persons.add(p);
        when(personRepository.findAll()).thenReturn(persons);*/
        personService.getPersons();
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void getPersonFromLastNameAndFirstName_ShouldUsePersonRepository() {
        personService.getPersonFromLastNameAndFirstName(anyString(), anyString());
        verify(personRepository, times(1)).findByLastNameAndFirstName(anyString(), anyString());
    }

    @Test
    public void getPersonFromAddress_ShouldUsePersonRepository() {
        personService.getPersonFromAddress(anyString());
        verify(personRepository, times(1)).findPersonByAddress(anyString());
    }

    @Test
    public void deletePersonFromLastNameAndFirstName_ShouldUsePersonRepository() {
        personService.deletePersonFromLastNameAndFirstName(anyString(), anyString());
        verify(personRepository, times(1)).deletePersonByLastNameAndFirstName(anyString(), anyString());
    }
}
