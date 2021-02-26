package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.FirestationPeopleList;
import com.example.safetynetalert.service.FirestationPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class FirestationPeopleController {

    @Autowired
    FirestationPeopleService firestationPeopleService;

    @GetMapping("/firestation")
    public FirestationPeopleList getPeopleFromFirestationNumber(@PathParam("stationNumber") String stationNumber) {
        return firestationPeopleService.getPeopleFromFirestationNumber(stationNumber);
    }
}
