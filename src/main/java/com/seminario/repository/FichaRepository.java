package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seminario.model.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Long>{
	Ficha findByNome(String nome);
}
