package br.itb.projeto.teste3a.service;

import java.util.ArrayList;
import java.util.List;

import br.itb.projeto.teste3a.model.entity.Aluno;
import br.itb.projeto.teste3a.model.repository.AlunoRepository;

public class AlunoService implements AlunoRepository {

	@Override
	public Aluno find() {
		Aluno aluno = new Aluno(86248, "Gabriel.C", 9);
		return aluno;
	}

	@Override
	public List<Aluno> findAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(98234, "Vitor", 26));
		alunos.add(new Aluno(98232, "Claudio", 27));
		alunos.add(new Aluno(98124, "Gabriel", 28));
		// TODO Auto-generated method stub
		return alunos;
	}

	@Override
	public Aluno findByRm(long rm) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(98234, "Vitor", 26));
		alunos.add(new Aluno(98222, "Claudio", 27));
		alunos.add(new Aluno(98124, "Gabriel", 28));
		
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getRm() == rm) {
				return alunos.get(i);
				
			}
			
		}
		
		return null;
	}

}
