package br.itb.projeto.KitFit.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.itb.projeto.KitFit.model.entity.Assinatura;
import br.itb.projeto.KitFit.model.entity.Usuario;
import br.itb.projeto.KitFit.model.repository.AssinaturaRepository;
import br.itb.projeto.KitFit.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class AssinaturaService {

	private AssinaturaRepository assinaturaRepository;
	
	private UsuarioRepository usuarioRepository;

	
	public AssinaturaService(AssinaturaRepository assinaturaRepository, UsuarioRepository usuarioRepository) {
		super();
		this.assinaturaRepository = assinaturaRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public List<Assinatura> findAll(){
		List<Assinatura> assinaturas = assinaturaRepository.findAll();
		return assinaturas;
	}
	
	public Assinatura findById(long id) {
		Assinatura assinatura = assinaturaRepository.findById(id).orElseThrow();
		return assinatura;
	}
	

	
	//jakarta.transaction.Transactional
	@Transactional
	public Assinatura create(Assinatura assinatura) {
		
		return assinaturaRepository.save(assinatura);
	}
	
	@Transactional
	public Assinatura gerarCodigo(long id) {
		Optional<Assinatura> _assinatura = 
				assinaturaRepository.findById(id);
		
		if (_assinatura.isPresent()) {
			
			Assinatura assAtualizado = _assinatura.get();
			String codigo = "K" +
					assAtualizado.getId() + "I" +
					assAtualizado.getUsuario().getId() + "T" +
					assAtualizado.getKit().getId();
			
			assAtualizado.setCodigo(codigo);
			
			return assinaturaRepository.save(assAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Assinatura inativa(long id) {
		
		Optional<Assinatura> _assinatura = assinaturaRepository.findById(id);
		
		if (_assinatura.isPresent()) {
			Assinatura assinaturaAtualizada = _assinatura.get();
			assinaturaAtualizada.setStatusAssinatura("INATIVA");
			
			return assinaturaRepository.save(assinaturaAtualizada);
		}
		return null;
		
	}

	public Assinatura buscarAssinatura(Long id) {
		Usuario usuario = usuarioRepository.findAllById(id);
		Assinatura assinatura = assinaturaRepository.findByUsuario(usuario);
		
		return assinatura;
	}
	
}	








