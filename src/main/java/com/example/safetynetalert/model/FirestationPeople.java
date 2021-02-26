package com.example.safetynetalert.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
public class FirestationPeople {

    String firstName;
    String lastName;
    String address;
    String phone;

}
