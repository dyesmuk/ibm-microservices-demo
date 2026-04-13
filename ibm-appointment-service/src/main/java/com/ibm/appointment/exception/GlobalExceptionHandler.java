package com.ibm.appointment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.appointment.model.Appointment;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Appointment> handleAppointmentNotFoundException(AppointmentNotFoundException err) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", err.getMessage());
		ResponseEntity<Appointment> response = new ResponseEntity<Appointment>(null, headers, status);
		
		return response;
	}
}
