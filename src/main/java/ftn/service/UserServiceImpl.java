package ftn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ftn.entity.User;
import ftn.repository.UserRepository;

/**
 * User service interface implementation
 * 
 * implemented services:
 *  list all users
 * 	add and update user
 * 	get user by id
 * 	delete user
 * @author Boki
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getUser(String id) {
		User user = userRepository.findOne(Long.valueOf(id));
		return user;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.delete(Long.valueOf(id));
	}
	
	
}
