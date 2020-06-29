package com.seminario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seminario.model.Usuario;
import com.seminario.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/formulario")
	public ModelAndView formUser() {
		ModelAndView mv = new ModelAndView("formUser"); 
		return mv;
	}
	
	
	@PostMapping("/add")
	public ModelAndView addUser(Usuario usuario) {
		usuarioService.adicionarUsuario(usuario);
		ModelAndView mv = new ModelAndView("formUser"); 
		return mv;
	}
	
	@GetMapping("/count")
	public ResponseEntity <Usuario> ContUser(){
		Usuario user = usuarioService.retornaUser((long)1);
		return new ResponseEntity <Usuario> (user, HttpStatus.OK);
	}
	
	
	
}
