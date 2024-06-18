package br.itb.projeto.KitFit.model.repository;

import java.util.List;

import br.itb.projeto.KitFit.model.entity.Aluno;

public interface AlunoRepository {

	
	Aluno find();
	
	List<Aluno> findAll();
	
	Aluno findByRm(long rm);
	
}
