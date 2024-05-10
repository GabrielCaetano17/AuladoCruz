package br.itb.projeto.pizzaria3a.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.itb.projeto.pizzaria3a.model.entity.Produto;

public interface ProdutoRepository 
	
	extends JpaRepository<Produto, Long> {
	}	

		

