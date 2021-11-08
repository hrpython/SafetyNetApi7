package com.openclassroom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.repository.FloodRepository;

@RestController
@RequestMapping("")
public class FloodController {
    private FloodRepository floodrepository;
    private static Logger logger = LoggerFactory.getLogger(FloodController.class);

    public FloodController(FloodRepository floodrepository) {
	super();
	this.floodrepository = floodrepository;
    }

    // find person with city
    @GetMapping("/city")
    public ResponseEntity<List<Object[]>> retrievealertcity(@RequestParam String zip) {
	logger.info("C'est la fête au village avec le code zip : {}", zip);
	return new ResponseEntity<List<Object[]>>(floodrepository.findPersonFireAlertParamsNative(zip), HttpStatus.OK);
    }

    // find person within firestation
    @GetMapping("/firestation")
    public ResponseEntity<List<Object[]>> firestationstationnumber(@RequestParam String firestation) {
	logger.info("C'est la fête au village avec le code firestation : {}", firestation);
	return new ResponseEntity<List<Object[]>>(floodrepository.firestationstationnumber(firestation), HttpStatus.OK);
    }

    // find person within childalert
    @GetMapping("/childAlert")
    public ResponseEntity<List<Object[]>> childAlert(@RequestParam String address) {
	logger.info("C'est la fête au village avec childAlert : {}", address);
	return new ResponseEntity<List<Object[]>>(floodrepository.childAlert(address), HttpStatus.OK);
    }

    // find person within phoneAlert
    @GetMapping("/phoneAlert")
    public ResponseEntity<List<Object[]>> phoneAlert(@RequestParam String station) {
	logger.info("C'est la fête au village avec phoneAlert : {}", station);
	return new ResponseEntity<List<Object[]>>(floodrepository.phoneAlert(station), HttpStatus.OK);
    }

    // find person within fireadress
    @GetMapping("/fire")
    public ResponseEntity<List<Object[]>> fireaddress(@RequestParam String address) {
	logger.info("C'est la fête au village avec fireAlert : {}", address);
	return new ResponseEntity<List<Object[]>>(floodrepository.fireAddress(address), HttpStatus.OK);
    }

    // find person within flood
    @GetMapping("/flood")
    public ResponseEntity<List<Object[]>> floodStation(@RequestParam String station) {
	logger.info("C'est la fête au village avec floodAlert : {}", station);
	return new ResponseEntity<List<Object[]>>(floodrepository.floodStation(station), HttpStatus.OK);
    }

    // find person within personinfo
    @GetMapping("/personInfo")
    public ResponseEntity<List<Object[]>> personInfo(@RequestParam String lastname) {
	logger.info("C'est la fête au village avec personInfo : {}", lastname);
	return new ResponseEntity<List<Object[]>>(floodrepository.personInfo(lastname), HttpStatus.OK);
    }

    // find email
    @GetMapping("/communityEmail")
    public ResponseEntity<List<Object[]>> email(@RequestParam String city) {
	logger.info("C'est la fête au village avec commùunityEmail: {}", city);
	return new ResponseEntity<List<Object[]>>(floodrepository.email(city), HttpStatus.OK);
    }
}
