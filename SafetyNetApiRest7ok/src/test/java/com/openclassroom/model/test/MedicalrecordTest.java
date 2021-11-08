
package com.openclassroom.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassroom.model.Medicalrecord;

public class MedicalrecordTest {
    private Medicalrecord medicalrecord;

    @BeforeEach
    void setup() {
	medicalrecord = new Medicalrecord();
    }

    @Test
    void test() {
	medicalrecord.setAllergies("None");
	medicalrecord.setFirstName("Jean");
	medicalrecord.setLastName("Bon");
	medicalrecord.setMedications("Advil");
	assertEquals(medicalrecord.getAllergies(), "None");
	assertEquals(medicalrecord.getFirstName(), "Jean");
	assertEquals(medicalrecord.getLastName(), "Bon");
	assertEquals(medicalrecord.getMedications(), "Advil");

    }

}
