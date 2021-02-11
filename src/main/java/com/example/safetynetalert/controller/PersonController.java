package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public Iterable<Person> getPersons(){
        return personService.list();
    }

}