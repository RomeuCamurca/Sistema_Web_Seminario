package com.seminario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seminario.model.Role;
import com.seminario.model.Usuario;
import com.seminario.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<Integer> adicionar(Usuario usuario){
		
		Usuario u = usuarioService.buscarPorLogin(usuario.getLogin());
		
		if (u==null) {
		
		
			String permissao = usuario.getPermissao();
			String roleUser;
			
			if (permissao.equals("A")) {
				roleUser ="ROLE_ADMIN";
			}else {
				roleUser="ROLE_USER";
			}
			
			Role role = new Role();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			List<Role> roles = new ArrayList<Role>();
			role.setNomeRole(roleUser); // seta a role adm ou user
			usuarios.add(usuario); // adiciona o user no list
			roles.add(role); // adiciona a role no list
			role.setUsuarios(usuarios); // adiciona o list user na role
			usuario.setRoles(roles); // adiciona o list roles no user
			usuarioService.adicionarUsuario(usuario);
			
			return new ResponseEntity<Integer>(1,HttpStatus.OK);
		}else {
			return new ResponseEntity<Integer>(0,HttpStatus.OK);
		}
	}
	
	
	
	@GetMapping("/atualizar")
	public ModelAndView attUserGet(Usuario usuario) {
		ModelAndView mv = new ModelAndView("atualizarUser"); 
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	
	@PostMapping("/atualizar")
	public ModelAndView attUser(Usuario usuario) {
		usuarioService.atualizarUsuario(usuario);
		ModelAndView mv = new ModelAndView("redirect:/usuarios"); 
		return mv;
	}
	
	
	@GetMapping("/users")
	public ModelAndView listaUsuarios() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
		
		ModelAndView mv = new ModelAndView("usuarios"); 
		List<Usuario> usuarios = usuarioService.listaUsuarios();
		mv.addObject("logado", logado);
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping(value="/deletar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Integer> deletarUsuario(@PathVariable("id") Long id) {
		usuarioService.removerUsuario(id);
		return new ResponseEntity<Integer>(1,HttpStatus.OK);
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
