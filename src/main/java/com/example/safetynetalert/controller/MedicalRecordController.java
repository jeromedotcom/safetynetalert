package com.example.safetynetalert.controller;

import com.example.safetynetalert.SafetynetalertApplication;
import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    private Logger logger = LogManager.getLogger(MedicalRecordController.class);

    @PostMapping("/medicalRecord")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("requête POST sur le endpoint /medicalRecord avec le body medicalRecord: " + medicalRecord);
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    @GetMapping("/medicalRecord/{lastName}/{firstName}")
    public MedicalRecord getMedicalRecordFromLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        logger.info("requête GET sur le endpoint /medicalRecord avec les paramètres lastName: " + lastName + " et firstName: " + firstName);
        return medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
    }

    //TODO tester quand n'existe pas
    @PutMapping("/medicalRecord/{lastName}/{firstName}")
    public MedicalRecord updateMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName, @RequestBody MedicalRecord medicalRecord) {
        logger.info("requête PUT sur le endpoint /medicalRecord avec les paramètres lastName: " + lastName + " et firstName: " + firstName + " et le body" + medicalRecord);
        MedicalRecord m = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
        m.setAllergies(medicalRecord.getAllergies());
        m.setBirthdate(medicalRecord.getBirthdate());
        m.setMedications(medicalRecord.getMedications());
        medicalRecordService.saveMedicalRecord(m);
        return m;
    }

    @DeleteMapping("/medicalRecord/{lastName}/{firstName}")
    public void deleteMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        logger.info("requête DELETE sur le endpoint /medicalRecord avec les paramètres lastName: " + lastName + " et firstName: " + firstName);
        medicalRecordService.deleteMedicalRecordByLastNameAndFirstName(lastName, firstName);
    }
}
