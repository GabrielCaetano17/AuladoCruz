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
		List<Kit> kits = kitRepository.findByStatusKit("ATIVO");
		return kits;
	  }
	
	public Kit findById(long id) {
		Kit kit = kitRepository.findById(id).orElseThrow();
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
 
		Optional<Kit> _kit = kitRepository.findById(id);
 
		System.out.println("Aqui " + kit.getNome());
			if (_kit.isPresent()) {
			Kit kitAtualizado = _kit.get();

			kitAtualizado.setNome(kit.getNome());
			kitAtualizado.setDescricao(kit.getDescricao());
			kitAtualizado.setProdutos(kit.getProdutos());
			kitAtualizado.setPreco(kit.getPreco());
			kitAtualizado.setStatusKit(kit.getStatusKit());
			
			// Atualiza o usuário no banco de dados
			return kitRepository.save(kitAtualizado);
		}

		// Se o usuário não for encontrado, retorna null ou lança uma exceção
		return null;
	}
	
	
}
