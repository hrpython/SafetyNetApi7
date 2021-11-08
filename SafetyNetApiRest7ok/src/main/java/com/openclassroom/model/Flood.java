package com.openclassroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "floods")
public class Flood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getFirstname() {
	return firstName;
    }

    public void setFirstname(String firstname) {
	this.firstName = firstname;
    }

    public String getLastname() {
	return lastName;
    }

    public void setLastname(String lastname) {
	this.lastName = lastname;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

}
