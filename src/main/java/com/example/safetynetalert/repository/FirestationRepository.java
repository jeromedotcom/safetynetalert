package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.Firestation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Long> {

    Iterable<Firestation> getAllByStation(int station);
    List<String> (int station);

}
