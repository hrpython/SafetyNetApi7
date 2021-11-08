package com.openclassroom.service.impl;

import org.springframework.stereotype.Service;

import com.openclassroom.model.Firestation;
import com.openclassroom.repository.FirestationRepository;
import com.openclassroom.service.FirestationService;

@Service
public class FirestationServiceImpl implements FirestationService {
    private FirestationRepository firestationrepository;

    @Override
    public Firestation saveFirestation(Firestation firestation) {
	return firestationrepository.save(firestation);
    }

    public FirestationServiceImpl(FirestationRepository firestationrepository) {
	super();
	this.firestationrepository = firestationrepository;
    }

}
