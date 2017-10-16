package ftn.service;

import ftn.entity.Doctor;

/**
 * 
 * @author Boki
 *
 */
public interface DoctorService {

	Iterable<Doctor> list();

	Doctor getDoctor(String id);

	Doctor createDoctor(Doctor doctor);
	
	Doctor updateDoctor(Doctor doctor);
	
	void deleteDoctor(String id);

}
