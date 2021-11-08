package com.openclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.openclassroom.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonBylastName(String lastName);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT * FROM Persons as p WHERE p.first_name = :firstname and p.last_name = :lastname", nativeQuery = true)
    Person findUserByStatusAndNameNamedParamsNative(@Param("firstname") String firstname,
	    @Param("lastname") String lastname);

}
