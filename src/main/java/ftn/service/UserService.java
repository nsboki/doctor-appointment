package ftn.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ftn.entity.LoginUser;
import ftn.entity.User;

/**
 * User service interface shell for user services
 * 
 * services: list all users add and update user get user by id delete user
 * 
 * @author Boki
 *
 */
public interface UserService extends UserDetailsService {

	Iterable<User> list();

	User save(User user); // for add and update

	List<User> getAllUsers();

	User getUser(String id);

	void deleteUser(String id);

	User loggedInUser(LoginUser loginUser);

	User findByUsername(String name);

	// getAuthorities()

}
