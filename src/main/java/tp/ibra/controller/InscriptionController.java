package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Inscription;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.InscriptionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/inscription")
public class InscriptionController {
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Inscription saveInscription(@RequestBody Inscription inscription) {
		return inscriptionRepository.save(inscription);
	}

	@PutMapping("/update/{id}")
	public Inscription updateInscription(@PathVariable(value="id") int code, @RequestBody Inscription inscriptionDetails) {
		Inscription inscription = inscriptionRepository.findById(code)
				.orElseThrow(()-> new ResourceNotFoundException("inscription", "code", code));
		inscription.setEleve(inscriptionDetails.getEleve());
		inscription.setMontant(inscriptionDetails.getMontant());
		inscription.setClasse(inscriptionDetails.getClasse());
		inscription.setProgramme(inscription.getProgramme());
		return inscriptionRepository.save(inscription);
		
	}
}
