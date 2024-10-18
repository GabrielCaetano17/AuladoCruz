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
import br.itb.projeto.KitFit.model.entity.Kit;
import br.itb.projeto.KitFit.rest.response.MessageResponse;
import br.itb.projeto.KitFit.service.KitService;

@RestController
@RequestMapping("/kit/")
public class KitController {

	private KitService kitService;

	public KitController(KitService kitService) {
		super();
		this.kitService = kitService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Kit>> findAll() {
		List<Kit> kits = kitService.findAll();

		return new ResponseEntity<List<Kit>>(kits, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Kit> findById(@PathVariable long id) {
		Kit kit = kitService.findById(id);
		return new ResponseEntity<Kit>(kit, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Kit> create(@RequestBody Kit kit) {
		Kit _produto = kitService.create(kit);

		return new ResponseEntity<Kit>(_produto, HttpStatus.OK);
	}

	@PutMapping("alterar/{id}")
	public ResponseEntity<?> alterar(@PathVariable long id, @RequestBody Kit kit) {

		Kit _produto = kitService.alterar(id, kit);

		 return ResponseEntity.ok()

			.body(new MessageResponse("Kit: " + _produto.getNome() + " alterado com sucesso!"));
	}


	@PutMapping("inativa/{id}")
	public ResponseEntity<Kit> inativa(@PathVariable long id) {
		Kit _produto = kitService.inativa(id);

		return new ResponseEntity<Kit>(_produto, HttpStatus.OK);
	}

}
