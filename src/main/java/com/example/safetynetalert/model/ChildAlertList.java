package com.example.safetynetalert.model;

import com.example.safetynetalert.service.PersonService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class ChildAlertList {

    List<ChildAlert> child;
    List<Person> otherFamilyMembers;

}
