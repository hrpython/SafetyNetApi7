package com.openclassroom.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.openclassroom.repository.FloodRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class repositoryTest {
    @Autowired
    FloodRepository floodrepository;

    @BeforeEach
    void setup() throws Exception {

    }

    @Test
    final void testfindPersonFireAlertParamsNative() {
	Object object = floodrepository.findPersonFireAlertParamsNative("97541");
	assertNotNull(object);
    }

    @Test
    final void testfirestationstationnumber() {
	Object object = floodrepository.firestationstationnumber("97541");
	assertNotNull(object);
    }

    @Test
    final void testchildAlert() {
	Object object = floodrepository.childAlert("culv");
	assertNotNull(object);
    }

    @Test
    final void testphoneAlert() {
	Object object = floodrepository.phoneAlert("97541");
	assertNotNull(object);
    }

    @Test
    final void testfireAddress() {
	Object object = floodrepository.fireAddress("cul");
	assertNotNull(object);
    }

    @Test
    final void testfloodStation() {
	Object object = floodrepository.floodStation("97541");
	assertNotNull(object);
    }

    @Test
    final void testpersonInfo() {
	Object object = floodrepository.personInfo("Boy");
	assertNotNull(object);
    }

    @Test
    final void testemail() {
	Object object = floodrepository.email("cul");
	assertNotNull(object);
    }
}
