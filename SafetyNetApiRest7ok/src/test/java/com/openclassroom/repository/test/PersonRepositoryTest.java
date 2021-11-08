package com.openclassroom.repository.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.openclassroom.model.Person;
import com.openclassroom.repository.PersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    // Junit test for savePerson
    @Test
    public void savePersonTest() {
	Person person = new Person();
	person.setId(1);
	person.setFirstName("Jacky");
	person.setLastName("Chan");
	person.setAddress("Boulevard des combattants");
	person.setCity("HongKong");
	person.setZip("012354");
	person.setPhone("0645124578");
	person.setEmail("jchan@gmail.com");

	Person person2 = personRepository.save(person);
	Assertions.assertThat(person2.getId()).isGreaterThan(0);
    }

    // Junit for all persons
    @Test
    public void findPersonByLastNameTest() {
	Assertions.assertThat(personRepository.findByFirstNameAndLastName("John", "Boyd").getId()).isGreaterThan(0);
    }

}
