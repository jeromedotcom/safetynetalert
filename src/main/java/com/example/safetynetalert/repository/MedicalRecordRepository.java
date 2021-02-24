package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

    MedicalRecord findMedicalRecordByLastNameAndFirstName(String lastName, String firstName);

    void deleteMedicalRecordByLastNameAndFirstName(String lastName, String firstName);
}
