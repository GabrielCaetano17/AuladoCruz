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
			List<Adm> adms = admRepository.findAll();
			return adms;
			
		}
		
		@Transactional
		public Adm create(Adm adm) {
			
			String senha = Base64.getEncoder()
			.encodeToString(adm.getSenha().getBytes());
			adm.setSenha(senha);
			
			adm.setDataCadastro(LocalDateTime.now());
			adm.setStatusAdm("ATIVO");
			
			return admRepository.save(adm);
		}
	
@Transactional
	
	public Adm signin(String email, String senha) {
		Adm adm= admRepository.findByEmail(email);
		
		if (adm != null) {
		if (!adm.getStatusAdm().equals("INATIVO")) {
			byte[] decodedPass = Base64.getDecoder()
					.decode(adm.getSenha());
			if (new String(decodedPass).equals(senha)) {
				return adm;
			}
			
		}
	}
		return null;
	}
	
}
