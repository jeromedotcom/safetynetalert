package com.example.safetynetalert;

import com.example.safetynetalert.model.AllDataObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class SafetynetalertApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetynetalertApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            AllDataObject allDataObject = null;
            try {
            allDataObject = mapper.readValue(new File("src/main/resources/data.json"), AllDataObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.out.println(value);
            System.out.println(allDataObject.getFirestations().get(2).getAddress());
        };
    }
}
