package br.itb.projeto.pizzaria3a.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.pizzaria3a.model.entity.Mensagem;
import br.itb.projeto.pizzaria3a.model.entity.Usuario;
import br.itb.projeto.pizzaria3a.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
		
	}

	public Usuario findById(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(null);
		return usuario;
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {
		
		String senha = Base64.getEncoder()
				.encodeToString(usuario.getSenha().getBytes());
				usuario.setSenha(senha);
		
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setStatusUsuario("ATIVO");
		
		return usuarioRepository.save(usuario);
	}
	@Transactional
	
	public Usuario signin(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario.getStatusUsuario().equals("ATIVO")) {
			byte[] decodedPass = Base64.getDecoder()
					.decode(usuario.getSenha());
			if (new String(decodedPass).equals(senha)) {
				return usuario;
			}
			
		}
		return null;
	}
	
	@Transactional
	public Usuario inativa(long id) {
		
		Optional<Usuario> _usuario = usuarioRepository.findById(id);
		
		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();
			usuarioAtualizada.setStatusUsuario("INATIVA");
			
			return usuarioRepository.save(usuarioAtualizada);
		}
		return null;
		
	}
}
