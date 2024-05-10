package br.itb.projeto.pizzaria3a.model.repository;

import java.util.List;

import br.itb.projeto.pizzaria3a.model.entity.Aluno;

public interface AlunoRepository {

	
	Aluno find();
	
	List<Aluno> findAll();
	
	Aluno findByRm(long rm);
	
}
