package com.example.safetynetalert;

import com.example.safetynetalert.model.AllDataObject;
import com.example.safetynetalert.model.Person;
import com.example.safetynetalert.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SafetynetalertApplication {

    public AllDataObject allDataObject;

    public static void main(String[] args) {
        SpringApplication.run(SafetynetalertApplication.class, args);
    }
    @Autowired
    PersonService personService;
    @Bean
    CommandLineRunner runner() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            allDataObject = null;
            try {
            allDataObject = mapper.readValue(new File("src/main/resources/data.json"), AllDataObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println(allDataObject.getFirestations().get(2).getAddress());
            System.out.println(allDataObject.getMedicalrecords().toString());
            System.out.println(allDataObject.getMedicalrecords().remove(1));
            System.out.println(allDataObject.getMedicalrecords().toString());
            List<Person> persons = new ArrayList<>();
            persons = allDataObject.getPersons();
            System.out.println(persons);

            personService.save(persons);
            System.out.println("persons saved!");
        };





    }
}
