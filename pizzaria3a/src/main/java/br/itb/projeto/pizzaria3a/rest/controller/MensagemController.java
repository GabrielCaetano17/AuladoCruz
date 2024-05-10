package br.itb.projeto.pizzaria3a.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itb.projeto.pizzaria3a.model.entity.Mensagem;
import br.itb.projeto.pizzaria3a.service.MensagemService;


@RestController
@RequestMapping("/mensagem/")
public class MensagemController {
	 private MensagemService mensagemService;

	public MensagemController(MensagemService mensagemService) {
		super();
		this.mensagemService = mensagemService;
	}
	@GetMapping("findAll")
	
	public ResponseEntity<List<Mensagem>> findAll(){
		List<Mensagem> mensagens = mensagemService.findAll();
	
		return new ResponseEntity<List<Mensagem>>
		(mensagens, HttpStatus.OK);
	}
	
	@PostMapping("create")
		public ResponseEntity<Mensagem> create(
				@RequestBody Mensagem mensagem){
			
			Mensagem _mensagem = 
					mensagemService.create(mensagem);
			
			return new ResponseEntity<Mensagem> (_mensagem, HttpStatus.OK);
		
					
		}
		
}
