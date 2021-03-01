package com.example.safetynetalert.model;

import lombok.Data;

import java.util.List;

@Data
public class FloodList {
    String station;
    String address;
    List<FloodPeople> floodPeopleList;
}
