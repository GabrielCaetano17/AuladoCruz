package br.itb.projeto.KitFit.rest.controller;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itb.projeto.KitFit.model.entity.Usuario;
import br.itb.projeto.KitFit.service.AuthService;

@RestController
@RequestMapping("/api")

	public class AuthController {
	    @Autowired
	    private AuthService authService;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
	        String email = body.get("email");
	        @SuppressWarnings("unused")
			String senha = body.get("senha");

	        
	        Optional<Usuario> usuario = Optional.of(authService.autenticar(email));

	        if (usuario.isPresent()) {
	            return ResponseEntity.ok("Login bem-sucedido");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
	        }
	    }
	}


