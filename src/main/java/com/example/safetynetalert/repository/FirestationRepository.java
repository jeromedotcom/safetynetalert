package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.Firestation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface FirestationRepository extends CrudRepository<Firestation, Long> {
    Iterable<Firestation> findAllByStation(String station);

    Optional<Firestation> findByAddress(String address);

    void deleteByStation(String station);

    void deleteByAddress(String address);


}
