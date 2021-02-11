package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Iterable<Person> findByLastName(String LastName);
}
