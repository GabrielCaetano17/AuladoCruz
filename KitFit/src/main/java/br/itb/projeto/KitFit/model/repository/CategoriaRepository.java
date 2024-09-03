package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.itb.projeto.KitFit.model.entity.Categoria;

@Repository
public interface CategoriaRepository 


			extends JpaRepository<Categoria, Long> {
				
	}

