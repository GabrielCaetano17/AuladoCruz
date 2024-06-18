package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.KitFit.model.entity.Produto;

public interface ProdutoRepository 
	
	extends JpaRepository<Produto, Long> {
	}	

		

