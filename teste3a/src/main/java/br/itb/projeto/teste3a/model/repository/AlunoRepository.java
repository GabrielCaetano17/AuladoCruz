package br.itb.projeto.teste3a.model.repository;

import java.util.List;

import br.itb.projeto.teste3a.model.entity.Aluno;

public interface AlunoRepository {

	
	Aluno find();
	
	List<Aluno> findAll();
	
	Aluno findByRm(long rm);
	
}
