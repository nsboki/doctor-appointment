package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.Role;

/**
 * Role repository interface
 * use embedded CRUD operations with databases
 * @author Boki
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

}
