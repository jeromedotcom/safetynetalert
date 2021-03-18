package com.example.safetynetalert;

import com.example.safetynetalert.model.AllDataObject;
import com.example.safetynetalert.service.FirestationService;
import com.example.safetynetalert.service.MedicalRecordService;
import com.example.safetynetalert.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Profile("!test")
public class Runner implements CommandLineRunner {
    @Autowired
    PersonService personService;
    @Autowired
    FirestationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;

    private Logger logger = LogManager.getLogger(SafetynetalertApplication.class);

    @Override
    public void run(String... args) {
        logger.info("Initializing SafetyNetAlert");
        ObjectMapper mapper = new ObjectMapper();
        AllDataObject allDataObject = null;
        try {
            logger.debug("reading json file");
            allDataObject = mapper.readValue(new File("src/main/resources/data.json"), AllDataObject.class);
        } catch (Exception e) {
            logger.error("error reading json file" + e);
            e.printStackTrace();
        }
        logger.debug("saving persons");
        personService.savePersons(allDataObject.getPersons());
        logger.debug("saving firestations");
        firestationService.saveFirestations(allDataObject.getFirestations());
        logger.debug("saving medicalRecords");
        medicalRecordService.saveMedicalRecords(allDataObject.getMedicalrecords());

        logger.info("Datas saved!");
    }

}
