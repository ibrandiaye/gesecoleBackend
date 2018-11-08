package tp.ibra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Professeur;
import tp.ibra.entities.Tuteur;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.ProfesseurRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/professeur")
public class ProfesseurController {
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Professeur saveProfesseur(@RequestBody Professeur professeur) {
		return professeurRepository.save(professeur);
	}
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Collection<Professeur>> getAllProfesseur(){
		return new ResponseEntity<Collection<Professeur>>(professeurRepository.findAll(),HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public Professeur updateProfesseur(@PathVariable(value = "id") int code, @RequestBody Professeur professeurDetails){
		Professeur professeur = professeurRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("professeur", "code", code));
		
		professeur.setNom(professeurDetails.getNom());
		professeur.setPrenom(professeurDetails.getPrenom());
		professeur.setAdresse(professeurDetails.getAdresse());
		professeur.setTelephone(professeurDetails.getTelephone());
		
		return professeurRepository.save(professeur);
	}
}
