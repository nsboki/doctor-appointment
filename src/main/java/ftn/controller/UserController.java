package ftn.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.entity.User;
import ftn.service.UserService;

/**
 * UserController
 * 
 * path - user method mapping
 * 
 * @author Boki
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 
	 * @return users list
	 */
    @GetMapping( value = {"","/"})
	public Iterable<User> listUsers() {
		return userService.list();
	}
    
    /**
     * 
     * @param id
     * @return user with exact id
     */
    @GetMapping(value = {"/{id}"})
    public User getUser(@PathVariable String id) {
    	return userService.getUser(id);
    }
    
    /**
     * 
     * @param user
     * @return add new user
     */
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	/**
     * 
     * @param user
     * @return update existing user
     */
	@PutMapping("/save")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	/**
	 * delete user with exact id
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
