package com.ibm.patient.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.patient.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {

	Optional<Patient> findByEmail(String email);

}
