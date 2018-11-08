package tp.ibra.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import  tp.ibra.exceptions.ResourceNotFoundException;

import tp.ibra.entities.Eleve;
import tp.ibra.entities.Tuteur;
import tp.ibra.repository.EleveRepository;
import tp.ibra.repository.TuteurRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/eleve")
public class EleveController {
	@Autowired
	private EleveRepository eleveRepository;
	@Autowired
	private TuteurRepository TuteurRepository;
	//methode pour l'enregistrement d'un eleve
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Eleve saveEleve(@RequestBody Eleve eleve) {
		TuteurRepository.save(eleve.getTuteur());
		return eleveRepository.save(eleve);
	}
	//afficher tous les eleves
	@RequestMapping(value="/liste",method=RequestMethod.GET)
	public ResponseEntity<Collection<Eleve>> getAllEleve(){
		return new ResponseEntity<Collection<Eleve>>(eleveRepository.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/eleve/{id}")
	public Eleve getEleveById(@PathVariable(value="id") int id)
	{
		return eleveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Eleve", "Id", id));
	}
	@PutMapping("/update/{id}")
	public Eleve updateEleve(@PathVariable(value = "id") int code, @RequestBody Eleve eleveDetails){
		Eleve eleve = eleveRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("elve", "code", code));
		
		eleve.setNom(eleveDetails.getNom());
		eleve.setPrenom(eleveDetails.getPrenom());
		eleve.setAdresse(eleveDetails.getAdresse());
		eleve.setTelephone(eleveDetails.getTelephone());
		eleve.setDateNaissance(eleveDetails.getDateNaissance());
		eleve.setLieuNaissance(eleveDetails.getLieuNaissance());
		eleve.setImage(eleveDetails.getImage());
		return eleveRepository.save(eleve);
	}
	@RequestMapping(value="eleves/{classe}",method=RequestMethod.GET)
	public ResponseEntity<List<Eleve>> findEleveByclasse(@PathVariable("classe") String nom){
		return new ResponseEntity<List<Eleve>>(eleveRepository.getElevesByClasse(nom),HttpStatus.OK);
		
	}
	
}
