package com.example.safetynetalert.controller;

import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.PhoneAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PhoneAlertController {

    @Autowired
    PhoneAlertService phoneAlertService;

    @GetMapping("/phoneAlert")
    public List phoneAlert(@PathParam("firestation") String firestation) {
        return phoneAlertService.phoneAlert(firestation);
            }
}
