package com.openclassroom.service;

import java.util.List;

import com.openclassroom.model.Person;

public interface PersonService {
    Person savePerson(Person person);

    List<Person> getAllPersons();

    Person getPersonbyId(long id);

    Person updatePerson(Person person, long id);

    void deletePerson(long id);

    // Person getPersonBylastNameandfirstName(String firstname, String lastname);

}
