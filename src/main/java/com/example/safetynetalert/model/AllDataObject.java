package com.example.safetynetalert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


public class AllDataObject {

    public AllDataObject(){}

    private List<Person> persons = new ArrayList<Person>();
    private List<Firestation> firestations = new ArrayList<Firestation>();
    private List<MedicalRecord> medicalrecords = new ArrayList<MedicalRecord>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
