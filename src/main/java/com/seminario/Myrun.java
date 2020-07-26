package com.seminario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.seminario.model.Role;
import com.seminario.model.Usuario;
import com.seminario.repository.RoleRepository;
import com.seminario.repository.UsuarioRepository;
import com.seminario.service.RoleService;
import com.seminario.service.UsuarioService;

@Component
public class Myrun implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	UsuarioService usuarioService;
	
	@Autowired
	RoleService roleService;

	@Override
	public void run(String... args) throws Exception {
		Usuario user = new Usuario(1,"admin","padrao","(00)0 0000-00","admin@admin.com","$2a$10$QQTwiecWyXvN9.TmNQOXf.lqT7IOz0klLwF/R2MbUGIeEXsgjxTw2");
		boolean existe = usuarioService.userExist(1);
		boolean roleAdm = roleService.roleExist("ROLE_ADMIN");
		boolean roleUser = roleService.roleExist("ROLE_USER");
		if(existe == false && roleAdm == false && roleUser == false) {
			roleRepository.save(new Role("ROLE_ADMIN"));
			roleRepository.save(new Role("ROLE_USER"));
			Role ADM = new Role("ROLE_ADMIN");
			List<Usuario> usuarios = new ArrayList<Usuario>();
			List<Role> roles = new ArrayList<Role>();
			usuarios.add(user);
			roles.add(ADM);
			ADM.setUsuarios(usuarios);
			user.setRoles(roles);
			usuarioService.addPUser(user);
			
			

		}
		
	
	}

}

