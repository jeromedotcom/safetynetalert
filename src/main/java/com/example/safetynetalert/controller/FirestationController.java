package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FirestationController {
    @Autowired
    FirestationService firestationService;

    /**
     * CREATE add a new mapping
     * @param firestation mapping firestation / address
     * @return firestation mapping
     */
    @PostMapping("/firestation")
    public Firestation createFirestation(@RequestBody Firestation firestation) {
        return firestationService.saveFirestation(firestation);
    }

    /**
     * READ mapping station/addressé
     * @param station
     * @return mapping
     */
    @GetMapping("/firestation/{station}")
    public Iterable<Firestation> getFirestations(@PathVariable String station) {
        return firestationService.getFirestationsFromStationNumber(station);
    }

    @GetMapping("/firestation/address/{address}")
    public Optional<Firestation> getFirestation(@PathVariable String address) {
        return firestationService.getFirestationFromAddress(address);
    }

    @PutMapping("/firestation/{address}")
    public Firestation updateFirestation(@PathVariable("address") final String address, @RequestBody Firestation firestation) {
        Optional<Firestation> f = firestationService.getFirestationFromAddress(address);
        if(f.isPresent()) {
            Firestation currentFirestation = f.get();

            String station = firestation.getStation();
            currentFirestation.setStation(station);

            firestationService.saveFirestation(currentFirestation);
            return currentFirestation;
        } else {
            return null;
        }
    }

    @DeleteMapping("/firestation/{station}")
    public void deleteFirestationByStation(@PathVariable("station") String station) {
        firestationService.deleteFirestationByStation(station);
    }

    @DeleteMapping("/firestation/address/{address}")
    public void deleteFirestationByAddress(@PathVariable("address") String address) {
        firestationService.deleteFirestationByAddress(address);
    }
}
