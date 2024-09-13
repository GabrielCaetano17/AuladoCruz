package br.itb.projeto.KitFit.service;

import java.util.Optional;

import br.itb.projeto.KitFit.model.entity.Kit;
import br.itb.projeto.KitFit.model.entity.Mensalidade;
import br.itb.projeto.KitFit.model.entity.Usuario;
import br.itb.projeto.KitFit.model.repository.MensalidadeRepository;
import jakarta.transaction.Transactional;

public class MensalidadeService {
	
	private final MensalidadeRepository mensalidadeRepository;
	
	
	
	public MensalidadeService(MensalidadeRepository mensalidadeRepository) {
		super();
		this.mensalidadeRepository = mensalidadeRepository;
	}

	@Transactional
	public Mensalidade inativa(long id) {
		
		Optional<Mensalidade> _mensalidade = mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizado = _mensalidade.get();
			mensalidadeAtualizado.setStatusMensalidade("INATIVA");
			
			return mensalidadeRepository.save(mensalidadeAtualizado);
		}
		return null;
	}

	@Transactional
	public Mensalidade alterar(long id,  Mensalidade mensalidade) {
		
		Optional<Mensalidade> _mensalidade = mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizado = _mensalidade.get();
			
			mensalidadeAtualizado.setValor(mensalidadeAtualizado.getValor());
			
			return mensalidadeRepository.save(mensalidadeAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Mensalidade inativo(long id) {
		
		Optional<Mensalidade> _mensalidade = mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizada = _mensalidade.get();
			mensalidadeAtualizada.setStatusMensalidade("INATIVA");
			
			return mensalidadeRepository.save(mensalidadeAtualizada);
		}
		return null;
		
	}
	
	
	// Olhar sobre a a mensalidade de ativar sobre ela, arrumar o controller
	
	
	
}


	

