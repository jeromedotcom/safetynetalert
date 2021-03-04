package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FireList {
    String address;
    List<String> firestation;
    List<FirePeople> firePeopleList;

}
