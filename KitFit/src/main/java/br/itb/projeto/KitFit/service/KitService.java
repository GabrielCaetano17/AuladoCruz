package br.itb.projeto.KitFit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.itb.projeto.KitFit.model.entity.Kit;
import br.itb.projeto.KitFit.model.repository.KitRepository;
import jakarta.transaction.Transactional;



@Service
public class KitService {

	private KitRepository kitRepository;
	
	public KitService(KitRepository kitRepository) {
		super();
		this.kitRepository = kitRepository;
	}
	public List<Kit> findAll() {
		List<Kit> kits = kitRepository.findAll();
		return kits;
	  }
	
	public Kit findById(long id) {
		Kit kit = kitRepository
				.findById(id).orElseThrow();
		
		return kit;
	}
	
	@Transactional
	public Kit create(Kit kit) {

		kit.setStatusKit("ATIVO");
		
		return kitRepository.save(kit);
	}
	
	@Transactional
	public Kit inativa(long id) {
		
		Optional<Kit> _produto = kitRepository.findById(id);
		
		if (_produto.isPresent()) {
			Kit produtoAtualizado = _produto.get();
			produtoAtualizado.setStatusKit("INATIVO");
			
			return kitRepository.save(produtoAtualizado);
		}
		return null;
	}
	

	@Transactional
	public Kit alterar(long id, Kit kit) {
		
		Optional<Kit> _produto = kitRepository.findById(id);
		
		if (_produto.isPresent()) {
			Kit produtoAtualizado = _produto.get();
			
			produtoAtualizado.setPreco(kit.getPreco());
			
			return kitRepository.save(produtoAtualizado);
		}
		return null;
	}
	
	
}
