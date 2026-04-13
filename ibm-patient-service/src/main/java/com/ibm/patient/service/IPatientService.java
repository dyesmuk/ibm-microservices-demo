package com.ibm.patient.service;

import java.util.List;

import com.ibm.patient.model.Insurance;
import com.ibm.patient.model.Patient;

public interface IPatientService {

	public abstract String patientAdd(Patient patient);

	public abstract List<Patient> patients();

	public abstract Patient patientById(String patientId);

	public abstract Patient patientByEmail(String email);

	public abstract String patientUpdate(String patientId, Patient patient);

	public abstract String patientDelete(String patientId);

	public abstract List<Insurance> insurances();

	public abstract Insurance insuranceById(String insuranceId);

	public abstract Insurance insuranceByPatientId(String patientId);

	public abstract String insuranceUpdate(String insuranceId, Insurance insurance);

	public abstract String insuranceDelete(String insuranceId);

}
