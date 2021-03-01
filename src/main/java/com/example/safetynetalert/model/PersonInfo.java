package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class PersonInfo {
    String lastName;
    String address;
    int age;
    String email;
    List<String> medications;
    List<String> allergies;

}
