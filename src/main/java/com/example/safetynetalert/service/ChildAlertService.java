package com.example.safetynetalert.service;

import com.example.safetynetalert.model.ChildAlert;
import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildAlertService {
    @Autowired
    PersonService personService;

    public ChildAlertList getChildFromAddress(String address) {
        ChildAlertList childAlertList = new ChildAlertList();
        List childTransferList = new ArrayList();
        List adultTransferList = new ArrayList();
        Iterable<Person> personList = personService.getPersonFromAddress(address);
        for (Person person : personList
        ) {
            int age = personService.getAge(person.getLastName(), person.getFirstName());
            if (age<18) {
                ChildAlert childAlert = new ChildAlert();
                childAlert.setAge(age);
                childAlert.setFirstName(person.getFirstName());
                childAlert.setLastName(person.getLastName());
                childTransferList.add(childAlert);

            } else {
                adultTransferList.add(person);
            }
            childAlertList.setOtherFamilyMembers(adultTransferList);
            childAlertList.setChild(childTransferList);
        }
        return childAlertList;
    }

    public List getFamilyMembers(String address) {
        List familyMembers = new ArrayList();
        List<Person> personList = (List<Person>) personService.getPersonFromAddress(address);
        int i=0;
        for (Person person: personList
        ) {
            familyMembers.add(i++, person);
        }
        return familyMembers;
    }

}
