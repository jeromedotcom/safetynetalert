package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class FirestationPeople {
    List<FirestationPeople> firestationPeopleList;
    Long childCount;
    Long adultCount;
}
