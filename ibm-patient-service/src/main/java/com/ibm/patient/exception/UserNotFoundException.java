package com.ibm.patient.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5471546719229986009L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
