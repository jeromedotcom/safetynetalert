package com.example.safetynetalert.service;

import com.example.safetynetalert.controller.FirestationController;
import com.example.safetynetalert.model.Firestation;
import com.example.safetynetalert.repository.FirestationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = FirestationService.class)
@ActiveProfiles("test")
public class FirestationServiceTest {

    @MockBean
    FirestationRepository firestationRepository;
    @Autowired
    FirestationService firestationService;

    private Firestation f1;
    private Firestation f2;
    private List<Firestation> firestationList;

    @BeforeAll
    public static void initAll(){

    }

    @BeforeEach
    public void initEach(){
        f1 = new Firestation();
        f2 = new Firestation();
        f1.setStation("1");
        f1.setAddress("rue de Paris");
        f2.setStation("2");
        f2.setAddress("rue de Lille");
        firestationList = new ArrayList<>();
        firestationList.add(f1);
        firestationList.add(f2);
    }

    @Test
    public void saveFirestations_ShouldUseFirestationRepository() {
        firestationService.saveFirestations(firestationList);
        verify(firestationRepository, times(1)).saveAll(firestationList);
    }

    @Test
    public void saveFirestation_ShouldUseFirestationRepository() {
        firestationService.saveFirestation(f1);
        verify(firestationRepository, times(1)).save(f1);
    }

    @Test
    public void getFirestationFromAddress_ShouldUseFirestationRepository () {
        /*when(firestationRepository.findByAddress(any(String.class))).thenReturn(any(Optional.class));
        firestationService.getFirestationFromAddress(any(String.class));
        verify(firestationRepository, times(1)).findByAddress(any(String.class));*/

        when(firestationRepository.findByAddress("abc")).thenReturn(java.util.Optional.ofNullable(f1));
        firestationService.getFirestationFromAddress("abc");
        verify(firestationRepository, times(1)).findByAddress("abc");

    }

    @Test
    public void getFirestationsFromStationNumber_ShouldUseFirestationRepository () {
        when(firestationRepository.findAllByStation("1")).thenReturn(firestationList);
        firestationService.getFirestationsFromStationNumber("1");
        verify(firestationRepository, times(1)).findAllByStation("1");
    }

    @Test
    public void deleteFirestationByStation_ShouldUseFirestationRepository() {
        firestationService.deleteFirestationByStation(anyString());
        verify(firestationRepository, times(1)).deleteByStation(anyString());
    }

    @Test
    public void deleteFirestationByAddress_ShouldUseFirestationRepository() {
        firestationService.deleteFirestationByAddress(anyString());
        verify(firestationRepository, times(1)).deleteByAddress(anyString());
    }

    @Test
    public void deleteFirestationsByStation_ShouldUseFirestationRepository() {
        //GIVEN multiple firestations


        //firestationRepository.deleteFirestationsByStation("1");
        firestationRepository.deleteByStation("1");
        verify(firestationRepository, times(1)).deleteByStation("1");
        assertThat(firestationList.isEmpty());
    }

    /*@Test
    public void deleteNotExistingFirestation_ShouldNotUseFirestationRepository() {
        when(firestationService.getFirestationsFromStationNumber("3")).thenReturn(null);
        firestationRepository.deleteByStation("3");
    }*/
}
