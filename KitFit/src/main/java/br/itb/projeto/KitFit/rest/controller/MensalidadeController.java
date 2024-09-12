package br.itb.projeto.KitFit.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.KitFit.model.entity.Mensalidade;
import br.itb.projeto.KitFit.service.MensalidadeService;

@RestController
@RequestMapping("/Mensalidade/")
public class MensalidadeController {

	
	@PutMapping("inativa/{id}")
	public ResponseEntity<Mensalidade> inativa(
			@PathVariable long id) {
		Mensalidade _produto = MensalidadeService.inativa(id);
		
		return new ResponseEntity<Mensalidade>(
				_produto, HttpStatus.OK);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<Mensalidade> alterar(
			@PathVariable long id,
			@RequestBody Mensalidade mensalidade) {
		
		Mensalidade _mensalidade = MensalidadeService.alterar(id, mensalidade);
		
		return new ResponseEntity<Mensalidade>(
				_mensalidade, HttpStatus.OK);
	}
}
