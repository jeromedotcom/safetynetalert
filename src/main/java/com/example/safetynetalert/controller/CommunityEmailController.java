package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CommunityEmailController {
    @Autowired
    PersonService personService;

    @GetMapping("/communityEmail")
    public List getCommunityEmail(@PathParam("city") String city) {
        return personService.getEmailsFromCity(city);
    }

}
