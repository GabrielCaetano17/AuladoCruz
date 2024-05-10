package br.itb.projeto.pizzaria3a.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

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
		
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setStatusUsuario("ATIVO");
		
		return usuarioRepository.save(usuario);
	}
}
