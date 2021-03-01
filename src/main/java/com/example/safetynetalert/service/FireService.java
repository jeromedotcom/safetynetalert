package com.example.safetynetalert.service;

import com.example.safetynetalert.model.*;
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
        String station = firestationService.getFirestationFromAddress(address).get().getStation();fireList.setAddress(address);
        fireList.setFirestation(station);
        fireList.setFirePeopleList(firePeopleList);
        return fireList;

    }
}
