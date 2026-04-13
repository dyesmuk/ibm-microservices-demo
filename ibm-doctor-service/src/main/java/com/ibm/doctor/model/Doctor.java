package com.ibm.doctor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("doctors")
public class Doctor {

	@Id
	private String doctorId;

	private String name;
	private String gender;
	private String specialization;
	private String contact;

	private String email;

	private String password;

	public Doctor() {
		super();
	}

	public Doctor(String doctorId, String name, String gender, String specialization, String contact, String email,
			String password) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.gender = gender;
		this.specialization = specialization;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", gender=" + gender + ", specialization="
				+ specialization + ", contact=" + contact + ", email=" + email + ", password=" + password + "]";
	}

}
