package com.ibm.doctor.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.doctor.model.Doctor;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Doctor> handleUserNotFoundException(UserNotFoundException err) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", err.getMessage());
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(null, headers, status);
		
		return response;
	}
}
