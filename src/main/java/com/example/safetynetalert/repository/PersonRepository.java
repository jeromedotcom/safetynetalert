package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
    Iterable<Person> findByLastName(String LastName);

    Person findByLastNameAndFirstName(String lastName, String firstName);

    void deletePersonByFirstNameAndLastName(String lastName, String firstName);

    void deletePersonByLastNameAndFirstName(String lastName, String firstName);

    Iterable<Person> findPersonByAddress(String address);

    Iterable<Person> findAllByCity(String city);
}
