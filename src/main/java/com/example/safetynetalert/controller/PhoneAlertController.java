package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.PhoneAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PhoneAlertController {

    @Autowired
    PhoneAlertService phoneAlertService;

    private Logger logger = LogManager.getLogger(PhoneAlertController.class);

    @GetMapping("/phoneAlert")
    public List phoneAlert(@PathParam("firestation") String firestation) {
        logger.info("requête sur le endpoint /phoneAlert avec le paramètre firestation: " + firestation);
        return phoneAlertService.phoneAlert(firestation);
            }
}
