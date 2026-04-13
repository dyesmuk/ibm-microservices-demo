package com.ibm.appointment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("appointments")
public class Appointment {

	@Id
	private String appointmentId;

	private String doctorId;
	private String patientId;

	private String date;
	private String slot;
	private String status;

	public Appointment() {
		super();
	}

	public Appointment(String appointmentId, String doctorId, String patientId, String date, String slot,
			String status) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
		this.slot = slot;
		this.status = status;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", date=" + date + ", slot=" + slot + ", status=" + status + "]";
	}

}
