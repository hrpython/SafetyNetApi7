package com.openclassroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.openclassroom.model.Flood;

public interface FloodRepository extends JpaRepository<Flood, Long> {
    @Query(value = "SELECT medicalrecords.first_name, medicalrecords.last, persons.address, round((unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60)) as Age FROM medicalrecords,persons WHERE persons.zip = :zip and (unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60) < 18.0 and medicalrecords.first_name = persons.first_name and medicalrecords.last = persons.last_name ", nativeQuery = true)
    List<Object[]> findPersonFireAlertParamsNative(@Param("zip") String zip);

    @Query(value = "SELECT DISTINCT medicalrecords.first_name, medicalrecords.last,persons.address, persons.phone FROM medicalrecords, firestations,persons WHERE firestations.station = :firestation and firestations.address  LIKE concat('%',persons.address,'%') and medicalrecords.first_name = persons.first_name and medicalrecords.last = persons.last_name", nativeQuery = true)
    List<Object[]> firestationstationnumber(@Param("firestation") String firestation);

    @Query(value = "SELECT DISTINCT medicalrecords.first_name, medicalrecords.last, round((unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60)) FROM medicalrecords, firestations,persons WHERE  persons.address  LIKE %:address% and (unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60) < 18.0", nativeQuery = true)
    List<Object[]> childAlert(@Param("address") String address);

    @Query(value = "SELECT DISTINCT persons.phone FROM firestations,persons WHERE firestations.station = :station and firestations.address LIKE concat('%',persons.address,'%')", nativeQuery = true)
    List<Object[]> phoneAlert(@Param("station") String station);

    @Query(value = "SELECT DISTINCT persons.first_name, persons.last_name, medicalrecords.medication, medicalrecords.allergie FROM  firestations,persons,medicalrecords WHERE  persons.address  LIKE %:address% and firestations.address LIKE %:address% and persons.first_name = medicalrecords.first_name and persons.last_name = medicalrecords.last ", nativeQuery = true)
    List<Object[]> fireAddress(@Param("address") String address);

    @Query(value = "SELECT  medicalrecords.first_name, medicalrecords.last,persons.address, persons.phone , round((unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60)), medicalrecords.medication, medicalrecords.allergie FROM medicalrecords, firestations,persons  WHERE firestations.station = station and firestations.address  LIKE concat('%',persons.address,'%') and medicalrecords.first_name = persons.first_name and medicalrecords.last = persons.last_name GROUP BY persons.address", nativeQuery = true)
    List<Object[]> floodStation(@Param("station") String station);

    @Query(value = "SELECT DISTINCT medicalrecords.first_name, medicalrecords.last,persons.address, persons.email , round((unix_timestamp(CURRENT_TIMESTAMP)- unix_timestamp(medicalrecords.birthdate))/(365.2425*24*60*60)), medicalrecords.medication, medicalrecords.allergie FROM medicalrecords, firestations,persons WHERE persons.last_name LIKE %:lastname% and medicalrecords.last = persons.last_name and medicalrecords.first_name = persons.first_name ", nativeQuery = true)
    List<Object[]> personInfo(@Param("lastname") String lastname);

    @Query(value = "SELECT persons.email FROM persons WHERE persons.city LIKE %:city%", nativeQuery = true)
    List<Object[]> email(@Param("city") String city);

}
