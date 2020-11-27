package com.marius.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marius.model.Persoana;
import com.marius.repository.PersoanaRepository;

//In this class are implemented the methods
@Service  //Allow to use the methods defined in this class on the controller class
public class PersoanaService {
	
	@Autowired   //Is connecting PersoanaRepository to this class (PersoanaService)
	private PersoanaRepository persoanaRepository;
	
	public List<Persoana> retrieveAllPersons() {
		return persoanaRepository.findAll();
	}
	
	public Optional<Persoana> retrievePersoana(Long id) {
		return persoanaRepository.findById(id);
	}
	
	public void deletePersoana(Long id) {
		persoanaRepository.deleteById(id);
	}
	
	public Persoana createPersoana(Persoana persoana) {
		return persoanaRepository.save(persoana);
	}
	

}
