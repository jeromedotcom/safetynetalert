package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    /**
     * Create - save a new person
     * @param person
     * @return person saved
     */
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    /**
     * Read - Get all persons
     * @return an iterable of all persons
     */
    @GetMapping("/persons")
    public Iterable<Person> getPersons(){
        return personService.getPersons();
    }

    /*@GetMapping("/persons/lastName")
    public Iterable<Person> getPersonsFromFirstName(@PathParam("lastName") String lastName) {
        return personService.getPersonsFromLastName(lastName);
    }*/

    /**
     * Read - Get one person
     * @param lastName last name of the person
     * @param firstName first name of the person
     * @return an iterable of persons
     */
    // Todo utiliser optionnal si une seule personne ?
    @GetMapping("/person/{lastName}/{firstName}")
    public Optional<Person> getPersonFromLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        return personService.getPersonFromLastNameAndFirstName(lastName, firstName);
    }


    /**
     * Update - update an existing person
     * @param lastName used to identify the person, no update on this field
     * @param firstName used to identify the person, no update on this field
     * @param person
     * @return the person updated
     */
    @PutMapping("/person/{lastName}/{firstName}")
    public Person updatePerson(@PathVariable("lastName") final String lastName, @PathVariable("firstName") final String firstName, @RequestBody Person person) {
        //return personService.savePerson(person);
        Optional<Person> p = personService.getPersonFromLastNameAndFirstName(lastName, firstName);
        if(p.isPresent()) {
            Person currentPerson = p.get();

            String address = person.getAddress();
            if(address != null) {
                currentPerson.setAddress(address);
            }
            String city = person.getCity();
            if(city != null) {
                currentPerson.setCity(city);
            }
            String email = person.getEmail();
            if(email != null) {
                currentPerson.setEmail(email);
            }
            String zip = person.getZip();
            if(zip != null) {
                currentPerson.setZip(zip);
            }
            String phone = person.getPhone();
            if(phone != null) {
                currentPerson.setPhone(phone);
            }
            personService.savePerson(currentPerson);
            return currentPerson;
        } else {
            return null;
        }
    }

    /**
     *
     * @param lastName
     * @param firstName
     */
    @DeleteMapping("/person/{lastName}/{firstName}")
    public void deletePersonFromLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        personService.deletePersonFromLastNameAndFirstName(lastName, firstName);
    }

}