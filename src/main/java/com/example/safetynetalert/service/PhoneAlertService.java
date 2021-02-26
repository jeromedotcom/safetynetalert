package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.model.Person;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneAlertService {

    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;

    public List phoneAlert(String firestation) {
    Iterable<Firestation> firestations = firestationService.getFirestationsFromStationNumber(firestation);
    List phoneList = new ArrayList();
        for (Firestation firestation2: firestations
             ) {

            Iterable<Person> personList = personService.getPersonFromAddress(firestation2.getAddress());
            for (Person person: personList
                 ) {
                String phone = person.getPhone();
                if (!phoneList.contains(phone)) {
                    phoneList.add(phone);
                }
            }

        }
    return phoneList;

    }
}
