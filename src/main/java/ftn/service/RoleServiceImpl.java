package ftn.service;

import org.springframework.stereotype.Service;

import ftn.entity.Role;
import ftn.repository.RoleRepository;

/**
 * Role service interface implementation
 * 
 * implemented services:
 * 		list all roles
 * 		get role by id
 * 		add new role or update existing role
 * 		delete role
 * 
 * @author Boki
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Iterable<Role> list() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRole(String id) {
		return roleRepository.findOne(Long.valueOf(id));
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(String id) {
		roleRepository.delete(Long.valueOf(id));
	}

}
