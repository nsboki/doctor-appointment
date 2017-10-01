package rs.ac.uns.ftn.service;

import rs.ac.uns.ftn.entity.User;

public interface UserService {

	 Iterable<User> list();

	 User save(User user);

}
