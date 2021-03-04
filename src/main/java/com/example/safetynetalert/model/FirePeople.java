package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FirePeople {
    String lastName;
    String firstName;
    String phone;
    int age;
    List<String> medications;
    List<String> allergies;
}
