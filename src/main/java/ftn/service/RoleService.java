package ftn.service;

import ftn.entity.Role;

/**
 * Role service interface
 * shell for role services
 * 
 * list of service:
 * 		list all roles
 * 		get role by id
 * 		add and update role
 * 		delete role
 * 
 * @author Boki
 *
 */
public interface RoleService {

	Iterable<Role> list();

	Role getRole(String id);

	Role save(Role role);

	void deleteRole(String id);

}
