package com.example.safetynetalert.service;

import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonInfoService {

    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;

    public PersonInfo getAllInfoPerson(String firstName, String lastName) {
        //TODO si plus personnes
        Optional<Person> person = personService.getPersonFromLastNameAndFirstName(lastName, firstName);
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);

        int age = personService.getAge(lastName, firstName);

        PersonInfo allInfoPerson = new PersonInfo();
        allInfoPerson.setLastName(lastName);
        allInfoPerson.setAge(age);
        allInfoPerson.setAddress(person.get().getAddress());
        allInfoPerson.setEmail(person.get().getEmail());
        allInfoPerson.setAllergies(medicalRecord.getAllergies());
        allInfoPerson.setMedications(medicalRecord.getMedications());

        return allInfoPerson;
    }
}
