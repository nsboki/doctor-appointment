package ftn.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.entity.Patient;
import ftn.service.PatientService;

/**
 * 
 * @author Boki
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/patients")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@GetMapping(value = {"","/"})
	public Iterable<Patient> listPatients() {
		return patientService.list();
	}
	
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable String id) {
		return patientService.getPatient(id);
	}
	
	@PostMapping("/save")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	@PutMapping("/save")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable String id) {
		patientService.deletePatient(id);
	}
	
}
