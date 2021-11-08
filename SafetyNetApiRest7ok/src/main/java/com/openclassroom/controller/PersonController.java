package com.openclassroom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.model.Person;
import com.openclassroom.repository.PersonRepository;
import com.openclassroom.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    private PersonRepository personRepository;
    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonService personService, PersonRepository personRepository) {
	super();
	this.personService = personService;
	this.personRepository = personRepository;
    }

//build create person REST API
    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
	return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
    }

// build get all Person REST API
    @GetMapping
    public List<Person> getAllPersons() {
	return personService.getAllPersons();

    }

    // build get Person by id REST API
    // @GetMapping("{id}")
    // public ResponseEntity<Person> getPersonbyId(@PathVariable("id") long
    // personId) {
    // return new ResponseEntity<Person>(personService.getPersonbyId(personId),
    // HttpStatus.OK);

    // }

    // build get Person by lastName REST API
    @GetMapping("/lastname")
    public ResponseEntity<Person> findPersonbylastName(@RequestParam String lastName) {
	return new ResponseEntity<Person>(personRepository.findPersonBylastName(lastName), HttpStatus.OK);

    }

    // build get Person by lastName and firstName REST API
    @GetMapping("/totalname")
    public ResponseEntity<Person> findPersonbytotalName(@RequestParam String firstName, @RequestParam String lastName) {
	return new ResponseEntity<Person>(personRepository.findByFirstNameAndLastName(firstName, lastName),
		HttpStatus.OK);

    }

    // build update person REST API
    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long personId, @RequestBody Person person) {
	return new ResponseEntity<Person>(personService.updatePerson(person, personId), HttpStatus.OK);
    }

    // build delete person REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long personId) {
	personService.deletePerson(personId);
	return new ResponseEntity<String>("Person removes from database", HttpStatus.OK);
    }

    // find person with firstname lastname
    @GetMapping("/test")
    public ResponseEntity<Person> retrieveLF(@RequestParam String firstname, @RequestParam String lastname) {
	return new ResponseEntity<Person>(
		personRepository.findUserByStatusAndNameNamedParamsNative(firstname, lastname), HttpStatus.OK);
    }

}
