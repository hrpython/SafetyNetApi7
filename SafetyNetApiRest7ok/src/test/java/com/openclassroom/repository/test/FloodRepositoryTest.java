package com.openclassroom.repository.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.openclassroom.repository.FloodRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FloodRepositoryTest {
    @Autowired
    private FloodRepository floodrepository;

    @Test
    public void findpersonnfireAlertTest() {
	Assertions.assertThat(floodrepository.findPersonFireAlertParamsNative("97451").size()).isGreaterThan(0);
    }

    @Test
    public void findmedicalrecordTest() {
	Assertions.assertThat(floodrepository.firestationstationnumber("1").size()).isGreaterThan(0);
    }

    @Test
    public void findchildAlertTest() {
	Assertions.assertThat(floodrepository.childAlert("cul").size()).isGreaterThan(0);
    }

    @Test
    public void phoneAlertTest() {
	Assertions.assertThat(floodrepository.phoneAlert("1").size()).isGreaterThan(0);
    }

    @Test
    public void fireAdressTest() {
	Assertions.assertThat(floodrepository.fireAddress("Cul").size()).isGreaterThan(0);
    }

    @Test
    public void floodStationTest() {
	Assertions.assertThat(floodrepository.floodStation("2").size()).isGreaterThan(0);
    }

    @Test
    public void personInfoTest() {
	Assertions.assertThat(floodrepository.personInfo("Boyd").size()).isGreaterThan(0);
    }

    @Test
    public void emailCommonTest() {
	Assertions.assertThat(floodrepository.email("Cul").size()).isGreaterThan(0);
    }
}
