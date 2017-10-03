package ftn.service;

import ftn.entity.Appointment;

/**
 * Appointment service interface
 * shell for appointment services
 * 
 * list of service:
 * 		list all appointment
 * 		get appointment by id
 * 		add new or update existing appointment 
 * 		delete appointment
 * 
 * @author Boki
 *
 */
public interface AppointmentService {

	Iterable<Appointment> list();

	Appointment getAppointment(String id);

	Appointment save(Appointment a);

	void deleteAppointment(String id);

}
