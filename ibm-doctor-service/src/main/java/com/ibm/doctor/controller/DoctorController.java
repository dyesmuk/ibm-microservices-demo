package com.ibm.doctor.controller;

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

import com.ibm.doctor.model.Doctor;
import com.ibm.doctor.service.IDoctorService;

@RestController
@RequestMapping("/ibm-doctor")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	@PostMapping(path = "/doctors", consumes = "application/json")
	public ResponseEntity<String> doctorAdd(@RequestBody Doctor doctor) {

		String message = doctorService.doctorAdd(doctor);

		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@GetMapping(path = "/doctors", produces = "application/json")
	public ResponseEntity<List<Doctor>> doctors() {

		List<Doctor> doctersList = doctorService.doctors();

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Doctor>> response = new ResponseEntity<List<Doctor>>(doctersList, status);

		return response;
	}

	@GetMapping(path = "/doctors/{id}", produces = "application/json")
	public ResponseEntity<Doctor> doctorById(@PathVariable(name = "id") String doctorId) {

		Doctor doctorObj = doctorService.doctorById(doctorId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(doctorObj, status);

		return response;
	}

	@GetMapping(path = "/doctor", produces = "application/json")
	public ResponseEntity<Doctor> doctorByEmail(@RequestParam String email) {

		Doctor doctorObj = doctorService.doctorByEmail(email);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(doctorObj, status);

		return response;
	}

	@PutMapping(path = "/doctors/{id}")
	public ResponseEntity<String> doctorUpdate(@PathVariable(name = "id") String doctorId, @RequestBody Doctor doctor) {
		String message = doctorService.doctorUpdate(doctorId, doctor);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

	@DeleteMapping(path = "/doctors/{id}")
	public ResponseEntity<String> doctorDelete(@PathVariable(name = "id") String doctorId) {

		String message = doctorService.doctorDelete(doctorId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);

		return response;
	}

}
