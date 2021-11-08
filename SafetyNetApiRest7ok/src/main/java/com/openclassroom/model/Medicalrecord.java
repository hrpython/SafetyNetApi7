package com.openclassroom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "medical_records")
public class Medicalrecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last", nullable = false)
    private String lastName;
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;
    @Column(name = "medication", nullable = false)
    private String medications;

    public void setId(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Date getBirthdate() {
	return birthdate;
    }

    public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
    }

    public String getMedications() {
	return medications;
    }

    public void setMedications(String medications) {
	this.medications = medications;
    }

    public String getAllergies() {
	return allergies;
    }

    public void setAllergies(String allergies) {
	this.allergies = allergies;
    }

    @Column(name = "allergie", nullable = false)
    private String allergies;

}
