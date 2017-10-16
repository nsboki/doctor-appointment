package ftn.service;

import ftn.entity.Patient;

/**
 * 
 * @author Boki
 *
 */
public interface PatientService {
	
	Iterable<Patient> list();

	Patient getPatient(String id);
	
	Patient createPatient(Patient patient);
	
	Patient updatePatient(Patient patient);
	
	void deletePatient(String id);
}
