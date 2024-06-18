package br.itb.projeto.KitFit.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.KitFit.model.entity.Mensagem;

@Repository
public interface MensagemRepository 


	extends JpaRepository<Mensagem, Long> {
}
