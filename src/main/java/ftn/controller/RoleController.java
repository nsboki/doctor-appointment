package ftn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.entity.Role;
import ftn.service.RoleService;

/**
 * Role controller
 * 
 * path - role method mapping
 *  
 * @author Boki
 *
 */

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	/**
	 * 
	 * @return roles list
	 */
	@GetMapping(value = {"","/"}) 
	public Iterable<Role> listRole() {
		return roleService.list();
	}
	
	/**
	 * 
	 * @param id
	 * @return role with exact id
	 */
	@GetMapping(value = {"/{id}"})
	public Role getRole(@PathVariable String id) {
		return roleService.getRole(id);
	}
	
	/**
	 * 
	 * 
	 * @param role
	 * @return add new role or update existing one
	 */
	@PostMapping("/save") 
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}
	
	/**
	 * delete existing role with exact id
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable String id) {
		roleService.deleteRole(id);
	}
	
	
}
