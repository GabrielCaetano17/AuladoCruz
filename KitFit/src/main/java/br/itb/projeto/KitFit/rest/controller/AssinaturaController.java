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
import br.itb.projeto.KitFit.model.entity.Assinatura;
import br.itb.projeto.KitFit.rest.response.MessageResponse;
import br.itb.projeto.KitFit.service.AssinaturaService;

@RestController
@RequestMapping("/assinatura/")
public class AssinaturaController {

	private AssinaturaService assinaturaService;

	public AssinaturaController(AssinaturaService assinaturaService) {
		super();
		this.assinaturaService = assinaturaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Assinatura>> findAll() {
		List<Assinatura> assinaturas = assinaturaService.findAll();

		return new ResponseEntity<List<Assinatura>>(assinaturas, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Assinatura> findById(@PathVariable long id) {
		Assinatura assinatura = assinaturaService.findById(id);
		return new ResponseEntity<Assinatura>(assinatura, HttpStatus.OK);
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
	
	@PutMapping("inativado/{id}")
	public ResponseEntity<Assinatura> inativa(
			@PathVariable long id) {
		Assinatura _assinatura = assinaturaService.inativa(id);
		
		return new ResponseEntity<Assinatura>(
				_assinatura, HttpStatus.OK);
	}
	
//	@PostMapping("/generate-code") 
//    public ResponseEntity<Assinatura> generateCode(@RequestBody CodeRequest request) {
//        String code = assinaturaService();
//        return ResponseEntity.ok(code);
//    }
	
	@GetMapping("buscarAssinaturaUsuario/{emailUsu}")
	public ResponseEntity<Assinatura> buscarAssinaturaUsuario(@PathVariable long emailUsu){
		Assinatura _assinatura = assinaturaService.buscarAssinatura(emailUsu);
		
		return new ResponseEntity<Assinatura>(_assinatura, HttpStatus.OK);
	}
}
