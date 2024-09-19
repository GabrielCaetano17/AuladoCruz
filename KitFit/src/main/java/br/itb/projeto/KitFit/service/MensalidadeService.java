package br.itb.projeto.KitFit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.KitFit.model.entity.Mensalidade;
import br.itb.projeto.KitFit.model.repository.MensalidadeRepository;
import jakarta.transaction.Transactional;

@Service
public class MensalidadeService {
	
	private MensalidadeRepository mensalidadeRepository;

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
	public Mensalidade ativo(long id) {
		
		Optional<Mensalidade> _mensalidade = mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizada = _mensalidade.get();
			mensalidadeAtualizada.setStatusMensalidade("ATIVO");
			
			return mensalidadeRepository.save(mensalidadeAtualizada);
		}
		return null;
		
	}
	
	

	
	
	
}


	

