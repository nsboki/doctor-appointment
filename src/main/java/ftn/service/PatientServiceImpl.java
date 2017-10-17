package ftn.service;

import org.springframework.stereotype.Service;

import ftn.entity.Patient;
import ftn.repository.PatientRepository;

/**
 * 
 * @author Boki
 *
 */
@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Iterable<Patient> list() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatient(String id) {
		return patientRepository.findOne(Long.valueOf(id));
	}

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(String id) {
		patientRepository.delete(Long.valueOf(id));
	}

}
