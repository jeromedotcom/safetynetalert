package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CommunityEmailController {
    @Autowired
    PersonService personService;

    private Logger logger = LogManager.getLogger(CommunityEmailController.class);

    @GetMapping("/communityEmail")
    public List getCommunityEmail(@PathParam("city") String city) {
        logger.info("requête GET sur le endpoint /communityEmail avec le paramètre city: " + city);
        return personService.getEmailsFromCity(city);
    }

}
