package com.ibm.patient.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.patient.model.Insurance;
import com.ibm.patient.model.Patient;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Patient> handleUserNotFoundException(UserNotFoundException err) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", err.getMessage());
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(null, headers, status);
		
		return response;
	}
	
	@ExceptionHandler(InsuranceNotFoundException.class)
	public ResponseEntity<Insurance> handleInsuranceNotFoundException(InsuranceNotFoundException err) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", err.getMessage());
		ResponseEntity<Insurance> response = new ResponseEntity<Insurance>(null, headers, status);
		
		return response;
	}
}
