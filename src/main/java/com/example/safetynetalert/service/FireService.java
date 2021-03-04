package com.example.safetynetalert.service;

import com.example.safetynetalert.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FireService {
    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;

    private Logger logger = LogManager.getLogger(FireService.class);

    public FireList getPeopleWhenFire(String address) {
        List<FirePeople> firePeopleList = new ArrayList<>();
        Iterable<Person> persons = personService.getPersonFromAddress(address);
        for (Person person : persons
             ) {
            FirePeople firePeople = new FirePeople();
            firePeople.setFirstName(person.getFirstName());
            firePeople.setLastName(person.getLastName());
            firePeople.setPhone(person.getPhone());
            int age = personService.getAge(person.getLastName(), person.getFirstName());
            firePeople.setAge(age);
            MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(person.getLastName(), person.getFirstName());
            firePeople.setMedications(medicalRecord.getMedications());
            firePeople.setAllergies(medicalRecord.getAllergies());
            firePeopleList.add(firePeople);

        }

        FireList fireList = new FireList();
        List<String> stationList = new ArrayList<>() ;
        firestationService.getFirestationFromAddress(address)
                .forEach(firestation -> stationList.add(firestation.getStation()));
        fireList.setAddress(address);
        fireList.setFirestation(stationList);
        fireList.setFirePeopleList(firePeopleList);
        logger.info("réponse en retour à la requête GET sur le endpoint /fire avec le paramètre address: " + address);
        return fireList;

    }
}
