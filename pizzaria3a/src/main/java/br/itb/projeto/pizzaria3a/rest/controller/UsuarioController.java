package br.itb.projeto.pizzaria3a.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.pizzaria3a.model.entity.Usuario;
import br.itb.projeto.pizzaria3a.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
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

	@PostMapping
	public ResponseEntity<?> signin(
			@RequestParam String email,
			@RequestParam String senha) {
			
			Usuario usuario = usuarioService.signin(email, senha);
			if(usuario != null) {
		return ResponseEntity.ok().body(usuario);
	}
	return ResponseEntity.badRequest()
			.body("Dados incorretos ");
}

}
