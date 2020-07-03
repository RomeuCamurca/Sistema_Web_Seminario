package com.seminario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seminario.model.Usuario;
import com.seminario.repository.UsuarioRepository;
@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public void adicionarUsuario(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public void removerUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public void atualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public int ContUser() {
		return (int) usuarioRepository.count();
		
	}
	
	public Usuario retornaUser(Long id) {
		return usuarioRepository.getOne(id);
	}	
	
}
