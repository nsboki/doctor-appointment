package ftn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.entity.User;
import ftn.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
    @GetMapping( value = {"","/"})
	public Iterable<User> listUsers() {
		
		return userService.list();
	}
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
}
