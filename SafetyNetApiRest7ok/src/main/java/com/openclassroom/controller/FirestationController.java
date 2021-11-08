package com.openclassroom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.model.Firestation;
import com.openclassroom.service.FirestationService;

@RestController
@RequestMapping("/firestation")
public class FirestationController {
    private FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
	super();
	this.firestationService = firestationService;
    }

//build save API REST with Service
    @PostMapping()
    public ResponseEntity<Firestation> saveFirestation(@RequestBody Firestation firestation) {
	return new ResponseEntity<Firestation>(firestationService.saveFirestation(firestation), HttpStatus.CREATED);
    }
}
