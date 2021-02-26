package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.ChildAlertList;
import com.example.safetynetalert.service.ChildAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ChildAlertController {
    @Autowired
    ChildAlertService childAlertService;

    @GetMapping("/childAlert")
    public ChildAlertList childAlert(@PathParam("address") String address) {
        return childAlertService.getChildFromAddress(address);

    }
}
