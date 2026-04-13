package com.ibm.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.patient.exception.InsuranceNotFoundException;
import com.ibm.patient.exception.UserNotFoundException;
import com.ibm.patient.model.Insurance;
import com.ibm.patient.model.Patient;
import com.ibm.patient.repository.InsuranceRepository;
import com.ibm.patient.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public String patientAdd(Patient patient) {
		patientRepository.save(patient);
		return "Patient added successfully!";
	}

	@Override
	public List<Patient> patients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient patientById(String patientId) {
		Optional<Patient> patientObj = patientRepository.findById(patientId);

		if (patientObj.isPresent()) {
			return patientObj.get();
		} else {
			String errorMessage = "Patient with userID " + patientId + " not found!";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public Patient patientByEmail(String email) {
		Optional<Patient> patientObj = patientRepository.findByEmail(email);

		if (patientObj.isPresent()) {
			return patientObj.get();
		} else {
			String errorMessage = "Patient with emailID " + email + " not found!";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public String patientUpdate(String patientId, Patient patient) {
		Optional<Patient> patientObj = patientRepository.findById(patientId);

		if (patientObj.isPresent()) {
			Patient existingPatient = patientObj.get();
			existingPatient.setName(patient.getName());
			existingPatient.setContact(patient.getContact());
			existingPatient.setEmail(patient.getEmail());
			existingPatient.setPassword(patient.getPassword());
			patientRepository.save(existingPatient);
			return "Updated successfully!";
		} else {
			String errorMessage = "Patient with patientId " + patientId + " not found! Unable to update.";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public String patientDelete(String patientId) {
		Optional<Patient> patientObj = patientRepository.findById(patientId);

		if (patientObj.isPresent()) {
			patientRepository.deleteById(patientId);
			return "Patient deleted successfully!";
		} else {
			String errorMessage = "Patient with userID " + patientId + " not found! Unable to delete.";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public List<Insurance> insurances() {
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance insuranceById(String insuranceId) {
		Optional<Insurance> insuranceObj = insuranceRepository.findById(insuranceId);

		if (insuranceObj.isPresent()) {
			return insuranceObj.get();
		} else {
			String errorMessage = "Insurance with insuranceId " + insuranceId + " not found!";
			throw new InsuranceNotFoundException(errorMessage);
		}
	}

	@Override
	public Insurance insuranceByPatientId(String patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);

		if (patient.isPresent()) {
			Patient patientObj = patient.get();
			String insuranceId = patientObj.getInsuranceId();

			if (insuranceId != null) {
				Optional<Insurance> insurance = insuranceRepository.findById(insuranceId);

				if (insurance.isPresent()) {
					return insurance.get();
				} else {
					String errorMessage = "Insurance not found for patient with patientID : " + patientId + " !";
					throw new InsuranceNotFoundException(errorMessage);
				}
			} else {
				String errorMessage = "Insurance not found for patient with patientID : " + patientId + " !";
				throw new InsuranceNotFoundException(errorMessage);
			}
		} else {
			String errorMessage = "Patient with userID " + patientId + " not found!";
			throw new UserNotFoundException(errorMessage);
		}
	}

	@Override
	public String insuranceUpdate(String insuranceId, Insurance insurance) {
		Optional<Insurance> insuranceObj = insuranceRepository.findById(insuranceId);

		if (insuranceObj.isPresent()) {
			Insurance existingInsurance = insuranceObj.get();

			existingInsurance.setType(insurance.getType());
			existingInsurance.setAmount(insurance.getAmount());
			insuranceRepository.save(existingInsurance);
			return "Updated successfully!";
		} else {
			String errorMessage = "Insurance with insuranceID " + insuranceId + " not found! Unable to update.";
			throw new InsuranceNotFoundException(errorMessage);
		}
	}

	@Override
	public String insuranceDelete(String insuranceId) {
		Optional<Insurance> insuranceObj = insuranceRepository.findById(insuranceId);

		if (insuranceObj.isPresent()) {
			insuranceRepository.deleteById(insuranceId);
			return "Insurance deleted successfully!";
		} else {
			String errorMessage = "Insurance with insuranceID " + insuranceId + " not found! Unable to delete.";
			throw new InsuranceNotFoundException(errorMessage);
		}
	}

}