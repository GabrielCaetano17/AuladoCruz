package br.itb.projeto.KitFit.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.KitFit.model.entity.Assinatura;
import br.itb.projeto.KitFit.rest.response.MessageResponse;
import br.itb.projeto.KitFit.service.AssinaturaService;

@RestController
@RequestMapping("/kits/")
public class AssinaturaController {

	private AssinaturaService assinaturaService;

	public AssinaturaController(AssinaturaService assinaturaService) {
		super();
		this.assinaturaService = assinaturaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Assinatura>> findAll() {
		List<Assinatura> exemplos = assinaturaService.findAll();

		return new ResponseEntity<List<Assinatura>>(exemplos, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Assinatura assinatura) {

		Assinatura _assinatura = 
				assinaturaService.create(assinatura);
		
		assinaturaService.gerarCodigo(_assinatura.getId());
		
		return ResponseEntity.ok()
				.body(new MessageResponse(
						"Assinatura cadastrado com sucesso!"));



	}
}
