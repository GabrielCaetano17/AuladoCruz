package br.itb.projeto.KitFit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.KitFit.model.entity.Assinatura;
import br.itb.projeto.KitFit.model.repository.AssinaturaRepository;
import jakarta.transaction.Transactional;

@Service
public class AssinaturaService {

	private AssinaturaRepository assinaturaRepository;

	public AssinaturaService(AssinaturaRepository assinaturaRepository) {
		super();
		this.assinaturaRepository = assinaturaRepository;
	}
	
	public List<Assinatura> findAll(){
		List<Assinatura> assinaturas = assinaturaRepository.findAll();
		return assinaturas;
	}
	
	//jakarta.transaction.Transactional
	@Transactional
	public Assinatura create(Assinatura assinatura) {
		
		return assinaturaRepository.save(assinatura);
	}
}







