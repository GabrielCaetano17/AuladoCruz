package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.KitFit.model.entity.Kit;

public interface KitRepository 
	
	extends JpaRepository<Kit, Long> {
	}	

		

