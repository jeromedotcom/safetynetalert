package com.example.safetynetalert.service;

import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.repository.FirestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService {
    @Autowired
    FirestationRepository firestationRepository;


    public void save(List<Firestation> firestations) {
        firestationRepository.saveAll(firestations);
    }
}
