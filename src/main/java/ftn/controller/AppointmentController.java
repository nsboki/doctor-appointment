package ftn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.entity.Appointment;
import ftn.service.AppointmentService;

/**
 * Appointment controller
 * 
 * path - appointment method mapping
 * 
 * @author Boki
 *
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	/**
	 * 
	 * @return appointments list
	 */
	@GetMapping(value = {"","/"})
	public Iterable<Appointment> listAppointment() {
		return appointmentService.list();
	}
	
	/**
	 * 
	 * @param id
	 * @return appointment with exact id
	 */
	@GetMapping(value = {"/{id}"})
	public Appointment getAppointment(@PathVariable String id) {
		return appointmentService.getAppointment(id);
	}
	
	/**
	 * 
	 * @param a
	 * @return add new appointment or update existing one (a)
	 */
	@PostMapping("/save")
	public Appointment saveAppointment(@RequestBody Appointment a) {
		return appointmentService.save(a);
	}
	
	/**
	 * delete existing appointment with exact id
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable String id) {
		appointmentService.deleteAppointment(id);
	}
	

}
