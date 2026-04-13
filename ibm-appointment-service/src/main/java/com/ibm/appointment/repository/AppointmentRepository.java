package com.ibm.appointment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.appointment.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

	List<Appointment> findByPatientId(String patientId);

	List<Appointment> findByDoctorId(String doctorId);

}
