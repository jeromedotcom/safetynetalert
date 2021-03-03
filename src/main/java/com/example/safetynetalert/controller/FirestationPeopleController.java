package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.FirestationPeopleList;
import com.example.safetynetalert.service.FirestationPeopleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class FirestationPeopleController {

    @Autowired
    FirestationPeopleService firestationPeopleService;

    private Logger logger = LogManager.getLogger(FirestationPeopleController.class);

    @GetMapping("/firestation")
    public FirestationPeopleList getPeopleFromFirestationNumber(@PathParam("stationNumber") String stationNumber) {
        logger.info("requête GET sur le endpoint /firestation avec le paramètre stationNumber: " + stationNumber);
        return firestationPeopleService.getPeopleFromFirestationNumber(stationNumber);
    }
}
