package com.seminario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seminario.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public boolean roleExist(String role) {
		return roleRepository.existsById(role);
	}
}
