package com.openclassroom.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassroom.model.Flood;

public class FloodTest {
    private Flood flood;

    @BeforeEach
    void setup() {
	flood = new Flood();
    }

    @Test
    void test() {
	flood.setAge(10);
	flood.setAddress("10 rue des Jonquilles");
	flood.setId(100l);
	flood.setFirstname("Popeye");
	flood.setLastname("Olive");
	assertEquals(flood.getAddress(), "10 rue des Jonquilles");
	assertEquals(flood.getAge(), 10);
	assertEquals(flood.getId(), 100l);
	assertEquals(flood.getFirstname(), "Popeye");
	assertEquals(flood.getLastname(), "Olive");

    }

}
