package com.openclassroom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.openclassroom.model.Person;
import com.openclassroom.repository.PersonRepository;
import com.openclassroom.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personrepository;

    @Override
    public Person savePerson(Person person) {
	return personrepository.save(person);
    }

    public PersonServiceImpl(PersonRepository personrepository) {
	super();
	this.personrepository = personrepository;
    }

    @Override
    public List<Person> getAllPersons() {
	return personrepository.findAll();
    }

    @Override
    public Person getPersonbyId(long id) {
	Optional<Person> person = personrepository.findById(id);
	try {
	    if (person.isPresent()) {
		return person.get();
	    }
	} catch (Exception e) {
	    System.out.println("no person for this id");// TODO: handle exception
	}
	return null;

    }

    @Override
    public Person updatePerson(Person person, long id) {
	// on doit vérifier que l'id est dans la base données
	Person existingPerson;
	Optional<Person> personupdate = personrepository.findById(id);
	try {
	    if (personupdate.isPresent()) {
		existingPerson = personupdate.get();
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setEmail(person.getEmail());
		existingPerson.setAddress(person.getAddress());
		existingPerson.setCity(person.getCity());
		existingPerson.setZip(person.getZip());
		existingPerson.setPhone(person.getPhone());
		// save existing person
		personrepository.save(existingPerson);
		return existingPerson;

	    }
	} catch (Exception e) {
	    System.out.println("no person for this id");// TODO: handle exception
	}
	return null;
    }

    @Override
    public void deletePerson(long id) {

	Optional<Person> personupdate = personrepository.findById(id);
	try {
	    if (personupdate.isPresent()) {

		personrepository.deleteById(id);

	    }
	} catch (Exception e) {
	    System.out.println("no person for this id");// TODO: handle exception
	}

    }

//    @Override
//    public Person getPersonBylastNameandfirstName(String firstname, String lastname) {
//	var person = personrepository.findByfirstNameAndlastName(firstname, lastname);
//	return person;
//    }

}
