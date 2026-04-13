package com.ibm.doctor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
public class TestController {

	@GetMapping(path = "/testing-purpose")
	public ResponseEntity<String> test() {
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<String> response = new ResponseEntity<String>("working...", status);
		return response;
	}

}
