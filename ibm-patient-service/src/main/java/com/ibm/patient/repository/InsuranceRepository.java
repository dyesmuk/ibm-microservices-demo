package com.ibm.patient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.patient.model.Insurance;

public interface InsuranceRepository extends MongoRepository<Insurance, String> {

}
