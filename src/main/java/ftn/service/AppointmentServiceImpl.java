package ftn.service;

import org.springframework.stereotype.Service;

import ftn.entity.Appointment;
import ftn.repository.AppointmentRepository;

/**
 * Appointment service interface implementation
 * 
 * list of implemented services:
 * 		list all appointment
 * 		get appointment by id
 * 		add new or update existing appointment 
 * 		delete appointment
 * @author Boki
 *
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private AppointmentRepository appointmentRepository;
	
	

	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public Iterable<Appointment> list() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointment(String id) {
		return appointmentRepository.findOne(Long.valueOf(id));
	}

	@Override
	public Appointment save(Appointment a) {
		return appointmentRepository.save(a);
	}

	@Override
	public void deleteAppointment(String id) {
		appointmentRepository.delete(Long.valueOf(id));
	}

}
