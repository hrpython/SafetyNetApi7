package com.openclassroom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openclassroom.model.Person;
import com.openclassroom.repository.PersonRepository;
import com.openclassroom.service.impl.PersonServiceImpl;

@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl personserviceimpl;
    @MockBean
    private PersonRepository personrepository;

    @Test
    public void test1() {
	doReturn(Optional.empty()).when(personrepository).findById(10l);
    }

    @Test
    public void test2() {
	Person person;
	Optional<Person> personupdate = personrepository.findById(10l);
	try {
	    if (personupdate.isPresent()) {
		person = personupdate.get();
		assertEquals(person.getId(), 10l);
	    }
	} catch (Exception e) {
	    System.out.println("loupé");
	}
    }

}
