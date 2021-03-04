package com.example.safetynetalert.service;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonInfoService {

    @Autowired
    PersonService personService;
    /*@Autowired
    FirestationService firestationService;*/
    @Autowired
    MedicalRecordService medicalRecordService;

    private Logger logger = LogManager.getLogger(PersonInfoService.class);

    public PersonInfo getAllInfoPerson(String firstName, String lastName) {
        //TODO si plus personnes
        //Person person = personService.getPersonFromLastNameAndFirstName(lastName, firstName);
        Person person = personService.getPersonFromLastNameAndFirstName(lastName, firstName);
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);

        int age = personService.getAge(lastName, firstName);
        PersonInfo allInfoPerson = new PersonInfo();
        allInfoPerson.setLastName(lastName);
        allInfoPerson.setAge(age);
        allInfoPerson.setAddress(person.getAddress());
        allInfoPerson.setEmail(person.getEmail());
        allInfoPerson.setAllergies(medicalRecord.getAllergies());
        allInfoPerson.setMedications(medicalRecord.getMedications());

        logger.info("réponse en retour à la requête GET sur le endpoint /personInfo avec les paramètres firstName: " + firstName + " et lastName: " + lastName);
        return allInfoPerson;
    }
}
