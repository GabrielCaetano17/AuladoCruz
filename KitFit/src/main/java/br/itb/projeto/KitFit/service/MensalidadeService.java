package br.itb.projeto.KitFit.service;

import java.util.Optional;

import br.itb.projeto.KitFit.model.entity.Kit;
import br.itb.projeto.KitFit.model.entity.Mensalidade;
import br.itb.projeto.KitFit.model.repository.MensalidadeRepository;
import jakarta.transaction.Transactional;

public class MensalidadeService {

	public static Mensalidade inativa(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Mensalidade alterar(long id, Mensalidade mensalidade) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*@Transactional
	public Mensalidade inativa(long id) {
		
		Optional<Mensalidade> _mensalidade = MensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizado = _mensalidade.get();
			MensalidadeAtualizado.setstatusMensalidade("INATIVA");
			
			return MensalidadeRepository.save(mensalidadeAtualizado);
		}
		return null;
	}

	@Transactional
	public Mensalidade alterar(long id,  Mensalidade, Mensalidade) {
		
		Optional<Mensalidade> _produto = MensalidadeRepository.findById(id);
		
		if (_produto.isPresent()) {
			Kit produtoAtualizado = _produto.get();
			
			produtoAtualizado.setPreco(kit.getPreco());
			
			return MensalidadeRepository.save(produtoAtualizado);
		}
		return null;
	}*/
	
	
	
	// Olhar sobre a a mensalidade de ativar sobre ela, arrumar o controller
	
	
}
