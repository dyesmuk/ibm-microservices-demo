package com.ibm.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.appointment.exception.AppointmentNotFoundException;
import com.ibm.appointment.model.Appointment;
import com.ibm.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public String appointmentAdd(Appointment appointment) {
		appointmentRepository.save(appointment);
		return "Appointment scheduled successfully!";
	}

	@Override
	public List<Appointment> appointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment appointmentById(String appointmentId) {
		Optional<Appointment> appointmentObj = appointmentRepository.findById(appointmentId);

		if (appointmentObj.isPresent()) {
			return appointmentObj.get();
		} else {
			String errorMessage = "Appointment with appointmentID " + appointmentId + " not found!";
			throw new AppointmentNotFoundException(errorMessage);
		}
	}

	@Override
	public List<Appointment> appointmentByPatientId(String patientId) {
		List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
		if (appointments.isEmpty()) {
			String errorMessage = "No appointments found for patient with patientID " + patientId;
			throw new AppointmentNotFoundException(errorMessage);
		}
		return appointments;
	}

	@Override
	public List<Appointment> appointmentByDoctorId(String doctorId) {
		// TODO Auto-generated method stub
		List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
		if (appointments.isEmpty()) {
			String errorMessage = "No appointments found for doctor with doctorID " + doctorId;
			throw new AppointmentNotFoundException(errorMessage);
		}
		return appointments;
	}

}
