package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.service.ChildAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ChildAlertController {
    @Autowired
    ChildAlertService childAlertService;

    private Logger logger = LogManager.getLogger(ChildAlertController.class);

    @GetMapping("/childAlert")
    public ChildAlertList childAlert(@PathParam("address") String address) {
        logger.info("requête sur le endpoint /childAlert avec le paramètre address: " + address);
        return childAlertService.getChildFromAddress(address);

    }
}
