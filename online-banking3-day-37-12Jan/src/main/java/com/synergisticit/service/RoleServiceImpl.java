package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Role;
import com.synergisticit.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public Role findById(Long roleId) {
	Optional<Role> optrole = roleRepository.findById(roleId);
		if(optrole.isPresent()) {
			return optrole.get();
		}
	
		return null;
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

}
