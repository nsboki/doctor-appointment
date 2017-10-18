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

import ftn.entity.Doctor;
import ftn.service.DoctorService;

/**
 * 
 * @author Boki
 *
 */

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@GetMapping(value= {"","/"})
	public Iterable<Doctor> listDoctors() {
		return doctorService.list();
	}
	
	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable String id) {
		return doctorService.getDoctor(id);
	}
	
	@PostMapping("/save")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}
	
	@PutMapping("/save")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable String id) {
		doctorService.deleteDoctor(id);
	}
	
}
