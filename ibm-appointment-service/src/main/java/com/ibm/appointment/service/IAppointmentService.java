package com.ibm.appointment.service;

import java.util.List;

import com.ibm.appointment.model.Appointment;

public interface IAppointmentService {

	public abstract String appointmentAdd(Appointment appointment);

	public abstract List<Appointment> appointments();

	public abstract Appointment appointmentById(String appointmentId);

	public abstract List<Appointment> appointmentByPatientId(String patientId);

	public abstract List<Appointment> appointmentByDoctorId(String doctorId);

}
