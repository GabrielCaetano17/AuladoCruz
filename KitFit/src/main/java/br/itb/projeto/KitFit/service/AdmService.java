package br.itb.projeto.KitFit.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import org.springframework.stereotype.Service;
import br.itb.projeto.KitFit.model.entity.Adm;
import br.itb.projeto.KitFit.model.repository.AdmRepository;
import jakarta.transaction.Transactional;


@Service
public class AdmService {

		private AdmRepository admRepository;

		public AdmService(AdmRepository admRepository) {
			super();
			this.admRepository = admRepository;
		}

		public List<Adm> findAll() {
			List<Adm> usuarios = admRepository.findAll();
			return adms;
			
		}

		public Adm findById(long id) {
			Adm adm = admRepository.findById(id).orElseThrow(null);
			return adm;
		}
		
		@Transactional
		public Adm create(Adm adm) {
			
			String senha = Base64.getEncoder()
			.encodeToString(adm.getSenha().getBytes());
			adm.setSenha(senha);
			
			usuario.setDataCadastro(LocalDateTime.now());
			usuario.setStatusUsuario("ATIVO");
			
			return admRepository.save(adm);
		}
	
@Transactional
	
	public Usuario signin(String email, String senha) {
		Usuario usuario = admRepository.findByEmail(email);
		
		if (usuario != null) {
		if (!usuario.getStatusUsuario().equals("INATIVO")) {
			byte[] decodedPass = Base64.getDecoder()
					.decode(usuario.getSenha());
			if (new String(decodedPass).equals(senha)) {
				return usuario;
			}
			
		}
	}
		return null;
	}
	
}
