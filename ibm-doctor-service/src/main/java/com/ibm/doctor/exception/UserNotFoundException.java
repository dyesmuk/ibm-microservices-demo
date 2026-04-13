package com.ibm.doctor.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6257860383555728292L;
	
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
