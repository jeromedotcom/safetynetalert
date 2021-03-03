package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.FireList;
import com.example.safetynetalert.model.FloodList;
import com.example.safetynetalert.service.FireService;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FireController {
    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    FireService fireService;

    private Logger logger = LogManager.getLogger(FireController.class);

    @GetMapping("/fire")
    public FireList getPeopleWhenFire(@PathParam("address") String address) {
        logger.info("requête GET sur le endpoint /fire avec le paramètre address: " + address);
        return fireService.getPeopleWhenFire(address);
    }
}
