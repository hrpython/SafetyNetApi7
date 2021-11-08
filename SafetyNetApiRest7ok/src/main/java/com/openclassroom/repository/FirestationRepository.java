package com.openclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassroom.model.Firestation;

public interface FirestationRepository extends JpaRepository<Firestation, Long> {

}
