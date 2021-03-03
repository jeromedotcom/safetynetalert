package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.FirestationPeopleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class FirestationController {
    @Autowired
    FirestationService firestationService;

    private Logger logger = LogManager.getLogger(FirestationController.class);

    /**
     * CREATE add a new mapping
     * @param firestation mapping firestation / address
     * @return firestation mapping
     */
    @PostMapping("/firestation")
    public Firestation createFirestation(@RequestBody Firestation firestation) {
        logger.info("requête POST sur le endpoint /firestation avec le body firestation: " + firestation);
        return firestationService.saveFirestation(firestation);
    }

    /**
     * READ mapping station/addressé
     * @param station
     * @return mapping
     */
    @GetMapping("/firestation/{station}")
    public Iterable<Firestation> getFirestationsFromStation(@PathVariable String station) {
        logger.info("requête GET sur le endpoint /firestation avec le paramètre station: " + station);
        return firestationService.getFirestationsFromStationNumber(station);
    }

    @GetMapping("/firestation/address/{address}")
    public Optional<Firestation> getFirestationFromAddress(@PathVariable String address) {
        logger.info("requête GET sur le endpoint /firestation/address avec le paramètre address: " + address);
        return firestationService.getFirestationFromAddress(address);
    }

    @PutMapping("/firestation/{address}")
    public Firestation updateFirestation(@PathVariable("address") final String address, @RequestBody Firestation firestation) {
        logger.info("requête PUT sur le endpoint /firestation avec le paramètre address: " + address);
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
        logger.info("requête DELETE sur le endpoint /firestation avec le paramètre station: " + station);
        firestationService.deleteFirestationByStation(station);
    }

    @DeleteMapping("/firestation/address/{address}")
    public void deleteFirestationByAddress(@PathVariable("address") String address) {
        logger.info("requête DELETE sur le endpoint /firestation/address avec le paramètre address: " + address);
        firestationService.deleteFirestationByAddress(address);
    }

}
