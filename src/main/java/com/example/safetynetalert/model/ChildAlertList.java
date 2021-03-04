package com.example.safetynetalert.model;

import com.example.safetynetalert.service.PersonService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
public class ChildAlertList {

    List<ChildAlert> child;
    List<Person> otherFamilyMembers;

}
