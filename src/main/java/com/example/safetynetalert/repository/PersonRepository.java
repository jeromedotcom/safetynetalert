package com.example.safetynetalert.repository;

import com.example.safetynetalert.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
    Iterable<Person> findByLastName(String LastName);

    Optional<Person> findByLastNameAndFirstName(String lastName, String firstName);

    void deletePersonByFirstNameAndLastName(String lastName, String firstName);

    void deletePersonByLastNameAndFirstName(String lastName, String firstName);
}
