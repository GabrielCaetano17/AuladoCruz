package br.itb.projeto.KitFit.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.itb.projeto.KitFit.model.entity.Adm;
import br.itb.projeto.KitFit.service.AdmService;

@RestController
@RequestMapping("/Adm")
public class AdmController {
<<<<<<< HEAD
	private AdmService AdmService;
	private Adm adm;
	
	
	
=======
	
	
	private AdmService AdmService;
	private Adm adm;
>>>>>>> 320ab0badb12f87bfce2ed550ebf3109c328a682
	public AdmController(AdmService admService) {
		super();
		this.AdmService = admService;
	}
	

	@GetMapping("findAll")
	public ResponseEntity<List<Adm>> findAll() {
		List<Adm> adms = null;
		try {
			adms = adm.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<List<Adm>>(adms, HttpStatus.OK);
	}
	
	

	@GetMapping("findById/{id}")
	public ResponseEntity<Adm> findById(@PathVariable long id) {

		//Adm adm = AdmService.findById(id);

		return new ResponseEntity<Adm>(adm, HttpStatus.OK);
	}
	
}
