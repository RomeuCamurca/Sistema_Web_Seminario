package com.seminario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seminario.model.Ficha;
import com.seminario.service.FichaService;

@Controller	
public class FichaControler {
	
	@Autowired
	FichaService fichaService;
	
	//retorna a página inicial
	@RequestMapping("/")
    public String index(){
        return "index";
    }
	
	//lista todas as fichas
	@RequestMapping(value = "/fichas", method = RequestMethod.GET)
	public ModelAndView listaFichas() {
		ModelAndView mv = new ModelAndView("fichas"); 
		List<Ficha> fichas = fichaService.listaFichas();
		mv.addObject("fichas", fichas);
		return mv;
	}
	
	//listar os detalhes de uma ficha
	@RequestMapping("/fichas/{id}")
	public ModelAndView detalhesFicha(@PathVariable("id") long id) {
		Ficha ficha = fichaService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("detalhesFicha");
		mv.addObject("ficha", ficha);
		return mv;
	}
	
	//retorna o formulario da ficha
	@RequestMapping(value="/cadastrarFicha", method = RequestMethod.GET)
	public ModelAndView formularioFicha(Ficha ficha) {
		
		ModelAndView mv = new ModelAndView("formFicha");
		mv.addObject("ficha", ficha);
		
		return mv;
	}
	
	//adicionar cadastro de ficha
	@RequestMapping(value="/cadastrarFicha", method=RequestMethod.POST)
    public ModelAndView adicionarFicha(@Valid Ficha ficha, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
        	return formularioFicha(ficha);
        }
        fichaService.adicionarFicha(ficha);
        ModelAndView mv = new ModelAndView("redirect:/cadastrarFicha");
        attributes.addFlashAttribute("mensagem", "Cadastro da ficha realizado com sucesso.");
        return mv;
    }
	
}
