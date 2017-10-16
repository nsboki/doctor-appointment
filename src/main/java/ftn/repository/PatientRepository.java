package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

}
