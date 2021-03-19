package com.example.safetynetalert.service;

import com.example.safetynetalert.model.*;
import com.example.safetynetalert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    MedicalRecordService medicalRecordService;

    private Logger logger = LogManager.getLogger(PersonService.class);


    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void savePersons(List<Person> persons) {
        personRepository.saveAll(persons);
    }


    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonFromLastNameAndFirstName(String lastName, String firstName) {
        return personRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public Iterable<Person> getPersonFromAddress(String address) {
        return personRepository.findPersonByAddress(address);
    }

    public void deletePersonFromLastNameAndFirstName(String lastName, String firstName) {
        personRepository.deletePersonByLastNameAndFirstName(lastName, firstName);
    }



    public int getAge(String lastName, String firstName){
        MedicalRecord m = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
        String birthdate = m.getBirthdate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthdate, formatter);
        LocalDate now = LocalDate.now();
        int age = dateOfBirth.until(now).getYears();
        logger.debug("calcul de l'âge pour " + firstName + " " + lastName + ": " + age);
        return age;
    }


    public List getEmailsFromCity(String city) {
        Iterable<Person> persons = personRepository.findAllByCity(city);
        List emails = new ArrayList();
        for (Person person : persons
             ) {
            if (!emails.contains(person.getEmail()))
            emails.add(person.getEmail());
        }
        return emails;
    }
}
