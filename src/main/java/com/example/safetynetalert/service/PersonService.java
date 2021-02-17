package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.repository.FirestationRepository;
import com.example.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService(){

    }

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void save(List<Person> persons) {
        personRepository.saveAll(persons);
    }


    public Iterable<Person> getPersonsFromLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public Iterable<Person> getPersonsFromFirestation(String station) {

        return null;
    }

    public void deletePersonFromLastNameAndFirstName(String lastName, String firstName) {
        personRepository.deletePersonByLastNameAndFirstName(lastName, firstName);
    }
}
