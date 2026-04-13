package com.ibm.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.appointment.model.Appointment;
import com.ibm.appointment.service.IAppointmentService;

@RestController
@RequestMapping("/ibm-appointment")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService;

	@PostMapping(path = "/appointments", consumes = "application/json")
	public ResponseEntity<String> appointmentAdd(@RequestBody Appointment appointment) {
		String message = appointmentService.appointmentAdd(appointment);
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);
		return response;
	}

	@GetMapping(path = "/appointments", produces = "application/json")
	public ResponseEntity<List<Appointment>> appointments() {
		List<Appointment> appointmentsList = appointmentService.appointments();
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Appointment>> response = new ResponseEntity<List<Appointment>>(appointmentsList, status);

		return response;
	}

	@GetMapping(path = "/appointments/{id}", produces = "application/json")
	public ResponseEntity<Appointment> appointmentById(@PathVariable(name = "id") String appointmentId) {

		Appointment appointmentObj = appointmentService.appointmentById(appointmentId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Appointment> response = new ResponseEntity<Appointment>(appointmentObj, status);

		return response;
	}

	@GetMapping(path = "/appointments/patient", produces = "application/json")
	public ResponseEntity<List<Appointment>> appointmentByPatientId(@RequestParam String patientId) {

		List<Appointment> appointmentList = appointmentService.appointmentByPatientId(patientId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Appointment>> response = new ResponseEntity<List<Appointment>>(appointmentList, status);

		return response;
	}

	@GetMapping(path = "/appointments/doctor", produces = "application/json")
	public ResponseEntity<List<Appointment>> appointmentByDoctorId(@RequestParam String doctorId) {

		List<Appointment> appointmentList = appointmentService.appointmentByDoctorId(doctorId);

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Appointment>> response = new ResponseEntity<List<Appointment>>(appointmentList, status);

		return response;
	}

}
