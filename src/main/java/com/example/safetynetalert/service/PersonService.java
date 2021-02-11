package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService(){

    }

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void save(List<Person> persons) {
        personRepository.saveAll(persons);
    }


}
