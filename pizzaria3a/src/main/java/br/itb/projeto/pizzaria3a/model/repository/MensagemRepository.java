package br.itb.projeto.pizzaria3a.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.pizzaria3a.model.entity.Mensagem;

@Repository
public interface MensagemRepository 


	extends JpaRepository<Mensagem, Long> {
}
