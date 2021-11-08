package com.openclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassroom.model.Medicalrecord;

public interface MedicalRecordRepository extends JpaRepository<Medicalrecord, Long> {

}
