package com.example.safetynetalert.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class FirestationPeople {

    String firstName;
    String lastName;
    String address;
    String phone;

}
