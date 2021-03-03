package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.service.PersonInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class PersonInfoController {

    @Autowired
    PersonInfoService personInfoService;

    private Logger logger = LogManager.getLogger(PersonInfoController.class);

    @GetMapping("/personInfo")
    public PersonInfo getAllInfoPerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        logger.info("requête GET sur le endpoint /personInfo avec les paramètres firstName: " + firstName + " et lastName: " + lastName);
        return personInfoService.getAllInfoPerson(firstName, lastName);
    }
}
