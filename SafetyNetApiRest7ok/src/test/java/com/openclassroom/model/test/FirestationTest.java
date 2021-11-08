package com.openclassroom.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassroom.model.Firestation;

public class FirestationTest {
    private Firestation firestation;

    @BeforeEach
    void setup() {
	firestation = new Firestation();
    }

    @Test
    void test() {
	firestation.setAddress("10 rue des Jonquilles");
	firestation.setStation("1");
	assertEquals(firestation.getAddress(), "10 rue des Jonquilles");
	assertEquals(firestation.getStation(), "1");

    }

}
