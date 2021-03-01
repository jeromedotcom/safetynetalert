package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class FirePeople {
    String lastName;
    String firstName;
    String phone;
    int age;
    List<String> medications;
    List<String> allergies;
}
