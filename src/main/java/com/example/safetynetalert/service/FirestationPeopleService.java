package com.example.safetynetalert.service;

import com.example.safetynetalert.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirestationPeopleService {

    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;
    /*@Autowired
    MedicalRecordService medicalRecordService;*/

    private Logger logger = LogManager.getLogger(FirestationPeopleService.class);

    /**
     * récupère la liste des personnes rattachés à une caserne et compte les adultes et enfants
     * @param stationNumber le numéro de la caserne
     * @return une liste comprenant le décompte des adultes et enfants ainsi que noms prénoms adresse et téléphone de chacun
     */

    public FirestationPeopleList getPeopleFromFirestationNumber(String stationNumber) {

        List<FirestationPeople> firestationPeopleList = new ArrayList<>();
        FirestationPeopleList firestationPeopleList2 = new FirestationPeopleList();

        int adultCount = 0;
        int childCount = 0;

        Iterable<Firestation> firestations = firestationService.getFirestationsFromStationNumber(stationNumber);

       for (Firestation firestation: firestations
             ) {
            Iterable<Person> persons = personService.getPersonFromAddress(firestation.getAddress());
            for (Person person : persons
                 ) {
                int age = personService.getAge(person.getLastName(), person.getFirstName());

                if (age>18) {
                    adultCount ++;
                } else {
                    childCount ++;
                }
                FirestationPeople firestationPeople = new FirestationPeople();
                firestationPeople.setFirstName(person.getFirstName());
                firestationPeople.setLastName(person.getLastName());
                firestationPeople.setAddress(person.getAddress());
                firestationPeople.setPhone(person.getPhone());
                firestationPeopleList.add(firestationPeople);
            }
        }
        firestationPeopleList2.setFirestationPeople(firestationPeopleList);
        firestationPeopleList2.setAdult(adultCount);
        firestationPeopleList2.setChild(childCount);
        logger.info("réponse en retour à la requête GET sur le endpoint /firestation avec le paramètre stationNumber: " + stationNumber);
        return firestationPeopleList2;


    }
}
