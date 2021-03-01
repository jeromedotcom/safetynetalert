package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.FloodList;
import com.example.safetynetalert.service.FloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FloodController {

    @Autowired
    FloodService floodService;

    @GetMapping("/flood/stations")
    public List getPeopleWhenFloodFromStationNumber(@PathParam("stationNumber") String stationNumber) {
        return floodService.getPeopleWhenFloodFromStationNumber(stationNumber);
    }
}
