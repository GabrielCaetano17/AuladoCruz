package br.itb.projeto.pizzaria3a.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.pizzaria3a.model.entity.Mensagem;
import br.itb.projeto.pizzaria3a.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;

@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}

	public List<Mensagem> findAll() {
		List<Mensagem> mensagems = mensagemRepository.findAll();
		return mensagems;
	}

	// jakarta.transaction.Transactional
	@Transactional
	public Mensagem create(Mensagem mensagem) {
		
		mensagem.setDataMensagem(LocalDateTime.now());
		mensagem.setStatusMensagem("ATIVO");

		return mensagemRepository.save(mensagem);
	}

}
