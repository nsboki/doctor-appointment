package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.User;
import java.lang.String;
import java.util.List;

/**
 * User repository interface
 * use embedded CRUD operations with database
 * @author Boki
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
