package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public Iterable<Person> getPersons(){
        return personService.list();
    }

    @GetMapping("/persons/lastName")
    public Iterable<Person> getPersonsFromFirstName(@PathParam("lastName") String lastName) {
        return personService.getPersonsFromLastName(lastName);
    }

    @GetMapping("/firestations")
    public Iterable<Person> getPersonsFromFirestation(@PathParam("station") String station) {
        return personService.getPersonsFromFirestation(station);
    }

}