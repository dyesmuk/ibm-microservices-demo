package com.ibm.patient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("patients")
public class Patient {

	@Id
	private String patientId;

	private String insuranceId;

	private String name;
	private String dateOfBirth;
	private String gender;
	private String contact;
	private String email;

	private String password;

	public Patient() {
		super();
	}

	public Patient(String patientId, String insuranceId, String name, String dateOfBirth, String gender, String contact,
			String email, String password) {
		super();
		this.patientId = patientId;
		this.insuranceId = insuranceId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceID(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", insuranceId=" + insuranceId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", contact=" + contact + ", email=" + email + ", password="
				+ password + "]";
	}

}
