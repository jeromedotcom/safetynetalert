package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FloodList {
    String station;
    String address;
    List<FloodPeople> floodPeopleList;
}
