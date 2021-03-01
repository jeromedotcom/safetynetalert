package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.PersonInfo;
import com.example.safetynetalert.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class PersonInfoController {

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public PersonInfo getAllInfoPerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        return personInfoService.getAllInfoPerson(firstName, lastName);
    }
}
