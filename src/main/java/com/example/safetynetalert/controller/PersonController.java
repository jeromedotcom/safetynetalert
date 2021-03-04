package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    private Logger logger = LogManager.getLogger(PersonController.class);

    /**
     * Create - save a new person
     * @param person
     * @return person saved
     */
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        logger.info("requête POST sur le endpoint /person avec le body person: " + person);

        return personService.savePerson(person);
    }

    /**
     * Read - Get all persons
     * @return an iterable of all persons
     */
    @GetMapping("/persons")
    public Iterable<Person> getPersons(){
        logger.info("requête GET sur le endpoint /persons");
        return personService.getPersons();
    }

    /**
     * Read - Get one person
     * @param lastName last name of the person
     * @param firstName first name of the person
     * @return an iterable of persons
     */
    @GetMapping("/person/{lastName}/{firstName}")
    public Person getPersonFromLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        logger.info("requête GET sur le endpoint /persons avec les paramètres lastName: " + lastName + " et firstName: " + firstName);
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
        logger.info("requête PUT sur le endpoint /person avec les paramètres lastName: " + lastName + " et firstName: " + firstName);

        Optional<Person> p = Optional.ofNullable(personService.getPersonFromLastNameAndFirstName(lastName, firstName));
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
        logger.info("requête DELETE sur le endpoint /person avec les paramètres lastName: " + lastName + " et firstName: " + firstName);

        personService.deletePersonFromLastNameAndFirstName(lastName, firstName);
    }

}