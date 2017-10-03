package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.User;

/**
 * User repository interface
 * use embedded CRUD operations with database
 * @author Boki
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {

}
