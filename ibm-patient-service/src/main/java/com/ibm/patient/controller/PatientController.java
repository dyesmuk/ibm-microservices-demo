package com.ibm.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.patient.model.Insurance;
import com.ibm.patient.model.Patient;
import com.ibm.patient.service.IPatientService;

@RestController
@RequestMapping("/ibm-patient")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class PatientController {

	@Autowired
	IPatientService patientService;

	@PostMapping(path = "/patients", consumes = "application/json")
	public ResponseEntity<String> patientAdd(@RequestBody Patient patient) {

		String message = patientService.patientAdd(patient);

		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@GetMapping(path = "/patients", produces = "application/json")
	public ResponseEntity<List<Patient>> patients() {

		List<Patient> patientsList = patientService.patients();

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Patient>> response = new ResponseEntity<List<Patient>>(patientsList, status);

		return response;
	}

	@GetMapping(path = "/patients/{id}", produces = "application/json")
	public ResponseEntity<Patient> patientById(@PathVariable(name = "id") String patientId) {

		Patient patientObj = patientService.patientById(patientId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(patientObj, status);

		return response;
	}

	@GetMapping(path = "/patient", produces = "application/json")
	public ResponseEntity<Patient> patientByEmail(@RequestParam String email) {

		Patient patientObj = patientService.patientByEmail(email);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(patientObj, status);

		return response;
	}

	@PutMapping(path = "/patients/{id}")
	public ResponseEntity<String> patientUpdate(@PathVariable(name = "id") String patientId,
			@RequestBody Patient patient) {

		String message = patientService.patientUpdate(patientId, patient);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@DeleteMapping(path = "/patients/{id}")
	public ResponseEntity<String> patientDelete(@PathVariable(name = "id") String patientId) {

		String message = patientService.patientDelete(patientId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@GetMapping(path = "/insurances", produces = "application/json")
	public ResponseEntity<List<Insurance>> insurances() {

		List<Insurance> insuranceList = patientService.insurances();

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Insurance>> response = new ResponseEntity<List<Insurance>>(insuranceList, status);

		return response;
	}

	@GetMapping(path = "/insurances/{id}")
	public ResponseEntity<Insurance> insuranceById(@PathVariable(name = "id") String insuranceId) {

		Insurance insuranceObj = patientService.insuranceById(insuranceId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Insurance> response = new ResponseEntity<Insurance>(insuranceObj, status);

		return response;
	}

	@GetMapping(path = "/insurances/patient-id", produces = "application/json")
	public ResponseEntity<Insurance> insuranceByPatientId(@RequestParam String patientId) {

		Insurance insuranceObj = patientService.insuranceByPatientId(patientId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Insurance> response = new ResponseEntity<Insurance>(insuranceObj, status);

		return response;
	}

	@PutMapping(path = "/insurances/{id}")
	public ResponseEntity<String> insuranceUpdate(@PathVariable(name = "id") String insuranceId,
			@RequestBody Insurance insurance) {

		String message = patientService.insuranceUpdate(insuranceId, insurance);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@DeleteMapping(path = "/insurances/{id}")
	public ResponseEntity<String> insuranceDelete(@PathVariable(name = "id") String insuranceId) {

		String message = patientService.insuranceDelete(insuranceId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}
}
