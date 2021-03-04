package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonInfo {
    String lastName;
    String address;
    int age;
    String email;
    List<String> medications;
    List<String> allergies;

}
