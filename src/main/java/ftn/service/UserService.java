package ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.entity.User;

/**
 * 
 * @author Boki
 *
 */

public interface UserService {

	Iterable<User> list();

	User save(User user);		//for add and update
	
	List<User> getAllUsers(); 	
	
	User getUser(String id);	
	
	void deleteUser(String id);
	
	

}
