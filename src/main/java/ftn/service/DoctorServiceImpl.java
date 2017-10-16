package ftn.service;

import org.springframework.stereotype.Service;

import ftn.entity.Doctor;
import ftn.repository.DoctorRepository;

/**
 * 
 * @author Boki
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService{

	private DoctorRepository doctorRepository;

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Iterable<Doctor> list() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctor(String id) {
		return doctorRepository.findOne(Long.valueOf(id));
	}

	@Override
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(String id) {
		doctorRepository.delete(Long.valueOf(id));
	}
	
	
}
