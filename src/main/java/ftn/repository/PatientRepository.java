package ftn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

	List<Patient> findByDoctor(Long doctorId);
}
