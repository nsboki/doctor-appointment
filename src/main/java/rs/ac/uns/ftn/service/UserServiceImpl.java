package rs.ac.uns.ftn.service;

import rs.ac.uns.ftn.entity.User;
import rs.ac.uns.ftn.repository.UserRepository;

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

}
