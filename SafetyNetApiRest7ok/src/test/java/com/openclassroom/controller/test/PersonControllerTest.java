
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
public class PersonControllerTest {
    @Autowired
    MockMvc mvc;

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

}
