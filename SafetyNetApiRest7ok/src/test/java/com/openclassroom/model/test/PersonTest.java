package com.openclassroom.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassroom.model.Person;

public class PersonTest {
    private Person person;

    @BeforeEach
    private void setUpPerTest() {
	person = new Person();
    }

    @Test
    public void test() {
	person.setAddress("rue");
	person.setCity("Paris");
	person.setEmail("paris@mail.com");
	person.setFirstName("Joanna");
	person.setLastName("Rza");
	person.setPhone("0625");
	person.setZip("75015");
	assertEquals(person.getAddress(), "rue");
	assertEquals(person.getCity(), "Paris");
	assertEquals(person.getEmail(), "paris@mail.com");
	assertEquals(person.getFirstName(), "Joanna");
	assertEquals(person.getLastName(), "Rza");
	assertEquals(person.getPhone(), "0625");
	assertEquals(person.getZip(), "75015");
    }

    @Test
    public void test2() {
	person.setAddress("rue");
	person.setCity("Paris");
	person.setEmail("paris@mail.com");
	person.setFirstName("Joanna");
	person.setLastName("Rza");
	person.setPhone("0625");
	person.setZip("75015");
	assertEquals(person.getAddress(), "rue");
	assertEquals(person.getCity(), "Paris");
	assertEquals(person.getEmail(), "paris@mail.com");
	assertEquals(person.getFirstName(), "Joanna");
	assertEquals(person.getLastName(), "Rza");
	assertEquals(person.getPhone(), "0625");
	assertEquals(person.getZip(), "75015");
    }
}
