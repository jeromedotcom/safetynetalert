package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class FireList {
    String address;
    String firestation;
    List<FirePeople> firePeopleList;
}
