package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.model.MergedObject;
import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.repository.PersonRepository;
import com.sun.scenario.effect.Merge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

     //TODO à supprimer après le test de merged object
    @Autowired
    private FirestationService firestationService;
    @Autowired
    private MedicalRecordService medicalRecordService;

    /*public PersonService(){

    }

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }*/

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void savePersons(List<Person> persons) {
        personRepository.saveAll(persons);
    }


    /*public Iterable<Person> getPersonsFromLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }*/

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonFromLastNameAndFirstName(String lastName, String firstName) {
        return personRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public Iterable<Person> getPersonFromAddress(String address) {
        return personRepository.findPersonByAddress(address);
    }

    public void deletePersonFromLastNameAndFirstName(String lastName, String firstName) {
        personRepository.deletePersonByLastNameAndFirstName(lastName, firstName);
    }



    //TODO à mettre dans medical record ?
    public int getAge(String firstName, String lastName){
        MedicalRecord m = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
        String birthdate = m.getBirthdate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthdate, formatter);
        //LocalDate dateOfBirth = LocalDate.of(1969, Month.SEPTEMBER, 11);
        LocalDate now = LocalDate.now();
        int age = dateOfBirth.until(now).getYears();
        System.out.println(age);
        return age;
    }

}
