package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seminario.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	Usuario findByLogin(String login);

}
