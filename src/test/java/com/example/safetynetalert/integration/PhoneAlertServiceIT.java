package com.example.safetynetalert.integration;

import com.example.safetynetalert.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneAlertServiceIT {
    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;
    @Autowired
    PhoneAlertService phoneAlertService;

    @Test
    public void testPhoneAlert() {
        List phoneAlertList = phoneAlertService.phoneAlert("1");
        assertEquals(4, phoneAlertList.size());
    }


}
