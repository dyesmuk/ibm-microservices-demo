package com.ibm.doctor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.doctor.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

	public abstract Optional<Doctor> findByEmail(String email);

}
