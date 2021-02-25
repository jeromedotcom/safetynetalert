package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.repository.FirestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirestationService {
    @Autowired
    FirestationRepository firestationRepository;


    public void saveFirestations(List<Firestation> firestations) {
        firestationRepository.saveAll(firestations);
    }

    public Firestation saveFirestation(Firestation firestation) {
        return firestationRepository.save(firestation);
    }

    public Iterable<Firestation> getFirestationsFromStationNumber(String station) {
        return firestationRepository.findAllByStation(station);
    }

    public Optional<Firestation> getFirestationFromAddress(String address) {
        return firestationRepository.findByAddress(address);
    }

    public void deleteFirestationByStation(String station) {
        firestationRepository.deleteByStation(station);
    }

    public void deleteFirestationByAddress(String address) {
        firestationRepository.deleteByAddress(address);
    }


}


