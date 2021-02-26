package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class FirestationPeopleList {
    int child;
    int adult;
    List<FirestationPeople> firestationPeople;



}
