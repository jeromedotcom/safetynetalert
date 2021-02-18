package com.example.safetynetalert;

import com.example.safetynetalert.model.*;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.MergedObjectService;
import com.example.safetynetalert.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SafetynetalertApplication {
    private Logger logger = LogManager.getLogger(SafetynetalertApplication.class);
    public AllDataObject allDataObject;

    public static void main(String[] args) {
        SpringApplication.run(SafetynetalertApplication.class, args);

    }
    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    MergedObjectService mergedObjectService;

    @Bean
    CommandLineRunner runner() {
        logger.info("Initializing SafetyNetAlert");
        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            allDataObject = null;
            try {
            allDataObject = mapper.readValue(new File("src/main/resources/data.json"), AllDataObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            personService.save(allDataObject.getPersons());
            firestationService.save(allDataObject.getFirestations());
            medicalRecordService.save(allDataObject.getMedicalrecords());
            logger.info("Datas saved!");
            System.out.println("persons saved!");
            //mergedObjectService.getPersonWithStation();
        };






    }
}
