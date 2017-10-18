package ftn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.entity.LoginUser;
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

	@Override
	public User loggedInUser(LoginUser loginUser) {
		User requestedUser = userRepository.findByUsername(loginUser.getUsername());
		if(requestedUser.getPassword().equals(loginUser.getPassword())) {
			return requestedUser;
		} else {
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User loggedInUser = userRepository.findByUsername(username);
		if (loggedInUser == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                final Collection<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(loggedInUser.getRole().name()));
                return authorities;
            }

            @Override
            public String getPassword() {
                return loggedInUser.getPassword();
            }

            @Override
            public String getUsername() {
                return loggedInUser.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

        };
	}

	@Override
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
	}
	
	
}
