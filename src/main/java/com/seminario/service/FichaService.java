package com.seminario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seminario.model.Ficha;
import com.seminario.repository.FichaRepository;

@Service
public class FichaService {

	@Autowired
	FichaRepository fichaRepository; 
	
	public void adicionarFicha(Ficha ficha) {
		fichaRepository.save(ficha);
	}
	
	public List<Ficha> listaFichas(){
		return fichaRepository.findAll();
	}
	
	public void removerFicha(Long id) {
		fichaRepository.deleteById(id);
	}
	
	public void atualizarFicha(Ficha ficha) {
		fichaRepository.save(ficha);
	}
	
	public Ficha buscarPorId(long id) {
		return fichaRepository.findById(id).get();
	}
	
	public Ficha buscarPorNome(String nome) {
		return fichaRepository.findByNome(nome);
	}
}
