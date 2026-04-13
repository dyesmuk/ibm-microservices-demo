package com.ibm.patient.exception;

public class InsuranceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1506066723087959244L;

	public InsuranceNotFoundException() {
		super();
	}

	public InsuranceNotFoundException(String errorMessage) {
		super(errorMessage);
	}	

}
