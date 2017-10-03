package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.Appointment;

/**
 * Appointment repository interface 
 * extends embedded CRUD operations 4 databases
 * @author Boki
 *
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
