package com.openclassroom.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Test runner.
 **/
@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration(classes = { RestConfigTest.class })
public final class FloodControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testfireAlert() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/city").param("zip", "97451")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Tenley"));
	;
    }

    @Test
    public void testfireStation() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/firestation").param("firestation", "1")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Peter"));
	;
    }

    @Test
    public void testChildAlert() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/childAlert").param("address", "cul")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Tenley"));
	;
    }

    @Test
    public void testphoneAlert() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/phoneAlert").param("station", "2")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("841-874-6513"));
	;
    }

    @Test
    public void test2() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/fire").param("address", "Culver")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Jacob"));
	;
    }

    @Test
    public void testflood() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/flood").param("station", "2")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Jacob"));
	;
    }

    @Test
    public void testpersoninfo() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/personInfo").param("lastname", "Boyd")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("Jacob"));
	;
    }

    @Test
    public void testemail() throws Exception {

	mvc.perform(MockMvcRequestBuilders.get("/communityEmail").param("city", "culver")).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0][0]").value("jaboyd@email.com"));
	;
    }
}
