package br.itb.projeto.KitFit.rest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itb.projeto.KitFit.model.entity.Usuario;
import br.itb.projeto.KitFit.rest.exception.ResourceNotFoundException;
import br.itb.projeto.KitFit.rest.response.MessageResponse;
import br.itb.projeto.KitFit.service.UsuarioService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = usuarioService.findAll();

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {

		Usuario usuario = usuarioService.findById(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	

	@PostMapping("create")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {

		Usuario _usuario = usuarioService.create(usuario);

		return new ResponseEntity<Usuario>(_usuario, HttpStatus.OK);
	}

	@PutMapping("alterar/{id}")

	public ResponseEntity<?> alterar(@PathVariable long id, @RequestBody Usuario usuario) {
 
		Usuario _usuario = usuarioService.alterar(id, usuario);
 
		return ResponseEntity.ok()

				.body(new MessageResponse("Usuário: " + _usuario.getEmail() + " alterado com sucesso!"));
	}


	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody Usuario usuario) {

		Usuario _usuario = usuarioService
				.signin(usuario.getEmail(), usuario.getSenha());

		if (_usuario == null) {
			throw new ResourceNotFoundException("*** Dados Incorretos! *** ");
		}

		return ResponseEntity.ok(_usuario);
	}
	

	@PutMapping("inativa/{id}")
	public ResponseEntity<Usuario> inativa(
			@PathVariable long id) {
		Usuario _usuario = usuarioService.inativa(id);
		
		return new ResponseEntity<Usuario>(
				_usuario, HttpStatus.OK);
	}
	
	@PutMapping("rativado/{id}")
	public ResponseEntity<Usuario> reativar(
			@PathVariable long id) {
		Usuario _usuario = usuarioService.reativar(id);
		
		return new ResponseEntity<Usuario>(
				_usuario, HttpStatus.OK);
	}
	

	
	
	
	@PutMapping("alterarSenha/{id}")
	public ResponseEntity<Usuario> alterarSenha(
			@PathVariable long id,
			@RequestBody Usuario usuario){
		Usuario _usuario = usuarioService.alterarSenha(id, usuario);
		
		return new ResponseEntity<Usuario>(
				_usuario, HttpStatus.OK);
	}

	
}
