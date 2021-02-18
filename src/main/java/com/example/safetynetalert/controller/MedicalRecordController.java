package com.example.safetynetalert.controller;

import com.example.safetynetalert.model.MedicalRecord;
import com.example.safetynetalert.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MedicalRecordController {
    @Autowired
    MedicalRecordService medicalRecordService;

    @PostMapping("/medicalRecord")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    @GetMapping("/medicalRecord/{lastName}/{firstName}")
    public MedicalRecord getMedicalRecordFromLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        return medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
    }

    //TODO tester quand n'existe pas
    @PutMapping("/medicalRecord/{lastName}/{firstName}")
    public MedicalRecord updateMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName, @RequestBody MedicalRecord medicalRecord) {
        MedicalRecord m = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
        m.setAllergies(medicalRecord.getAllergies());
        m.setBirthdate(medicalRecord.getBirthdate());
        m.setMedications(medicalRecord.getMedications());
        medicalRecordService.saveMedicalRecord(m);
        return m;
    }

    @DeleteMapping("/medicalRecord/{lastName}/{firstName}")
    public void deleteMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        medicalRecordService.deleteMedicalRecordByLastNameAndFirstName(lastName, firstName);
    }
}
