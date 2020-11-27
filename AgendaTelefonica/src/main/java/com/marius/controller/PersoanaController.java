package com.marius.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marius.model.Persoana;
import com.marius.repository.PersoanaRepository;
import com.marius.service.PersoanaService;


//This class provide RESTful end points for the the UI user
@RestController //Spring come here to check for the RESTful end points 
@RequestMapping("/api")
public class PersoanaController {
	
	@Autowired
	private PersoanaRepository persoanaRepository;
	
	@Autowired
	private PersoanaService persoanaService;
	
	
	@GetMapping("/persoane")
	public ResponseEntity<List<Persoana>> retrieveAll(){
		return ResponseEntity.ok(persoanaService.retrieveAllPersons());
	}
	
	@GetMapping("/persoana/{id}")
	public ResponseEntity getPersoanaById (@RequestBody Persoana persoana, @PathVariable Long id) {  
		return ResponseEntity.ok(persoanaService.retrievePersoana(id));
	}
	
	
	@DeleteMapping("/persoana/{id}")
	public void deletePersoanaById (@PathVariable Long id) {
		persoanaService.deletePersoana(id);
	}
	
	
	@PostMapping("/persoana") 
	public ResponseEntity create(@Validated @RequestBody Persoana persoana) {
		return ResponseEntity.ok(persoanaService.createPersoana(persoana));
	}
	
	
	@PutMapping("/persoana/{id}")	//is mapping a put request at the specified uri
	public ResponseEntity<Object> updatePersoana(@RequestBody Persoana persoana, @PathVariable Long id) {

		Optional<Persoana> persoanaOptional = persoanaRepository.findById(id);

		if (!persoanaOptional.isPresent())
			return ResponseEntity.notFound().build();

		persoana.setId(id);
		
		persoanaRepository.save(persoana);

		return ResponseEntity.noContent().build();
	}

}
