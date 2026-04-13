package com.ibm.doctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.doctor.exception.UserNotFoundException;
import com.ibm.doctor.model.Doctor;
import com.ibm.doctor.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public String doctorAdd(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);
		return "Doctor added successfully!";
	}

	@Override
	public List<Doctor> doctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor doctorById(String doctorId) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctorObj = doctorRepository.findById(doctorId);

		if (doctorObj.isPresent()) {
			return doctorObj.get();
		} else {
			String errorMessage = "Doctor with userID " + doctorId + " not found!";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public Doctor doctorByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctorObj = doctorRepository.findByEmail(email);

		if (doctorObj.isPresent()) {
			return doctorObj.get();
		} else {
			String errorMessage = "Doctor with emailID " + email + " not found!";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public String doctorUpdate(String doctorId, Doctor doctor) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctorObj = doctorRepository.findById(doctorId);

		if (doctorObj.isPresent()) {
			Doctor existingDoctor = doctorObj.get();

			existingDoctor.setName(doctor.getName());
			existingDoctor.setSpecialization(doctor.getSpecialization());
			existingDoctor.setEmail(doctor.getEmail());
			existingDoctor.setPassword(doctor.getPassword());
			doctorRepository.save(existingDoctor);
			return "Updated successfully!";
		} else {
			String errorMessage = "Doctor with userID " + doctorId + " not found! Unable to update.";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public String doctorDelete(String doctorId) {
		Optional<Doctor> doctorObj = doctorRepository.findById(doctorId);

		if (doctorObj.isPresent()) {
			doctorRepository.deleteById(doctorId);
			return "Doctor deleted successfully!";
		} else {
			String errorMessage = "Doctor with userID " + doctorId + " not found! Unable to delete.";
			throw new UserNotFoundException(errorMessage);
		}
	}

}
