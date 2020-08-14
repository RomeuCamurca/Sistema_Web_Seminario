package com.seminario.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.seminario.model.Ficha;
import com.seminario.model.Usuario;
import com.seminario.service.FichaService;
import com.seminario.service.UsuarioService;

@Controller	
public class FichaControler {
	
	@Autowired
	FichaService fichaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	//lista todas as fichas
	@RequestMapping(value = "/fichas", method = RequestMethod.GET)
	public ModelAndView listaFichas() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
		
		ModelAndView mv = new ModelAndView("fichas"); 
		List<Ficha> fichas = fichaService.listaFichas();
		mv.addObject("logado", logado);
		mv.addObject("fichas", fichas);
		return mv;
	}
	
	//listar os detalhes de uma ficha
	@RequestMapping("/fichas/{id}")
	public ModelAndView detalhesFicha(@PathVariable("id") long id) {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
		
		Ficha ficha = fichaService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("detalhesFicha");
		mv.addObject("logado", logado);
		mv.addObject("ficha", ficha);
		return mv;
	}
	
	//retorna o formulario de adicionar ficha ficha
	@RequestMapping(value="/cadastrarFicha", method = RequestMethod.GET)
	public ModelAndView formularioFicha(Ficha ficha) {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
		
		ModelAndView mv = new ModelAndView("formFicha");
		mv.addObject("logado", logado);
		mv.addObject("ficha", ficha);
		
		return mv;
	}
	
	//adicionar cadastro de ficha
	@RequestMapping(value="/cadastrarFicha", method=RequestMethod.POST)
    public ModelAndView adicionarFicha(@Valid Ficha ficha, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
        	return formularioFicha(ficha);
        }
        
        Ficha fichaVerificar = fichaService.buscarPorNome(ficha.getNome());
        
        if (fichaVerificar == null) {
        	fichaService.adicionarFicha(ficha);
	        ModelAndView mv = new ModelAndView("redirect:/cadastrarFicha");
	        attributes.addFlashAttribute("mensagem", "Cadastro da ficha realizado com sucesso.");
	        return mv;
        	
        }else {
        	ModelAndView mv = new ModelAndView("redirect:/cadastrarFicha");
            attributes.addFlashAttribute("mensagem", "A Ficha que você tentou cadastrar já existe.");
            return mv;
	        
        }
    }
        
	
	//retorna o formulario de atualizar ficha
	@RequestMapping(value="/atualizarFicha", method = RequestMethod.GET)
	public ModelAndView formularioAtFicha(Ficha ficha) {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
		
		ModelAndView mv = new ModelAndView("formAtFicha");
		mv.addObject("logado", logado);
		mv.addObject("ficha", ficha);
		
		return mv;
	}
	
	//usado para retornar a ficha em especifico para o formulario de adicionar
	@RequestMapping(value="/atualizar/{id}", method = RequestMethod.GET)
	public ModelAndView atualizarFicha(@PathVariable("id") Long id) {
		
		return formularioAtFicha(fichaService.buscarPorId(id));
	}
	
	//utiliza o metodo de atualizar do fichaService para atualizar a ficha
	@RequestMapping(value="/atualizarFicha", method=RequestMethod.POST)
	public ModelAndView salvarFicha(@Valid Ficha ficha, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return formularioAtFicha(ficha);
		}
		
		fichaService.atualizarFicha(ficha);
		ModelAndView mv = new ModelAndView("redirect:/fichas");
        attributes.addFlashAttribute("mensagem", "Ficha atualizada com sucesso.");
        return mv;
	}
	
	//metodo responsavel por deletar uma ficha em especifico
	@RequestMapping(value="/deletar/{id}", method = RequestMethod.GET)
	public ModelAndView deletarFicha(@PathVariable("id") Long id, RedirectAttributes attributes) {
		fichaService.removerFicha(id);
		ModelAndView mv = new ModelAndView("redirect:/fichas");
		attributes.addFlashAttribute("mensagem", "Ficha removida com sucesso.");
		return mv;
	}
	
		@RequestMapping(value = "/paroquias", method = RequestMethod.GET)
		public ModelAndView listaFichasParoquias() {
			Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails user = (UserDetails) auth;
			
			Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
			
			ModelAndView mv = new ModelAndView("filtroParoquia"); 
			List<Ficha> fichas = fichaService.listaFichas();
			mv.addObject("logado", logado);
			mv.addObject("fichas", fichas);
			return mv;
		}
		
		@RequestMapping(value = "/exportar", method = RequestMethod.GET)
		public ModelAndView exportarFichas() {
			Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails user = (UserDetails) auth;
			
			Usuario logado = usuarioService.buscarPorLogin(user.getUsername());
			
			ModelAndView mv = new ModelAndView("exportarFichas"); 
			List<Ficha> fichas = fichaService.listaFichas();
			mv.addObject("logado", logado);
			mv.addObject("fichas", fichas);
			return mv;
		}
	
}
