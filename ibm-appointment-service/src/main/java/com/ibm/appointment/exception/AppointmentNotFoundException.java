package com.ibm.appointment.exception;

public class AppointmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5196260796035815294L;

	public AppointmentNotFoundException() {
		super();
	}

	public AppointmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
