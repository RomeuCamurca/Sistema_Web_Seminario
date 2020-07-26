package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seminario.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	Usuario findByLogin(String login);
	

}
