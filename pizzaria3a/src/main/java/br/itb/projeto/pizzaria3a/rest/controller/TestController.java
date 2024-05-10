package br.itb.projeto.pizzaria3a.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping("test")
	public String getTest() {
		return "Escreva a sua mensagem aqui!";
	}
	
	
	// END POINT
	@GetMapping("message")
	public String getMessage() {
		return "Outra Mensagem...";
	}
	
	@GetMapping("Ola")
	public String getOla() {
		return "Olá, mundo! ";
	}
	
}
