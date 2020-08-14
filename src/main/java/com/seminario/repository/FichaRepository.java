package com.seminario.repository;
//responsavel por fazer transações com o banco de dados
import org.springframework.data.jpa.repository.JpaRepository;

import com.seminario.model.Ficha;
//jpa ajuda na persistência dos dados com métodos já existentes
public interface FichaRepository extends JpaRepository<Ficha, Long>{
	Ficha findByNome(String nome);
}
