package br.itb.projeto.KitFit.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itb.projeto.KitFit.service.AdmService;

@RestController
@RequestMapping("/Adm")
public class AdmController {

	private AdmService AdmService;

	public AdmController(AdmService admService) {
		super();
		this.admService = admService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Adm>> findAll() {
		List<Adm> adms = adm.findAll();

		return new ResponseEntity<List<Adm>>(adms, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {

		Usuario usuario = usuarioService.findById(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	
}
