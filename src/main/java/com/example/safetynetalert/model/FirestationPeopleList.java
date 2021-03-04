package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FirestationPeopleList {
    int child;
    int adult;
    List<FirestationPeople> firestationPeople;



}
