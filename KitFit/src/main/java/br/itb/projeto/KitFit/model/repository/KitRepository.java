package br.itb.projeto.KitFit.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.KitFit.model.entity.Kit;

public interface KitRepository extends JpaRepository<Kit, Long> {
	
	List<Kit> findByStatusKit(String status);
}
