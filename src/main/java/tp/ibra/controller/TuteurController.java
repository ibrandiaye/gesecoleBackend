package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Eleve;
import tp.ibra.entities.Tuteur;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.TuteurRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/tuteur")
public class TuteurController {
	@Autowired
	private TuteurRepository tuteurRepository;
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public Tuteur saveTuteur(@RequestBody Tuteur tuteur) {
		return tuteurRepository.save(tuteur);
	}
	@PutMapping("/update/{id}")
	public Tuteur updateProfesseur(@PathVariable(value = "id") int code, @RequestBody Tuteur tuteurDetails){
		Tuteur tuteur = tuteurRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("tuteur", "code", code));
		
		tuteur.setNom(tuteurDetails.getNom());
		tuteur.setPrenom(tuteurDetails.getPrenom());
		tuteur.setAdresse(tuteurDetails.getAdresse());
		tuteur.setTelephone(tuteurDetails.getTelephone());
		
		return tuteurRepository.save(tuteur);
	}

}
