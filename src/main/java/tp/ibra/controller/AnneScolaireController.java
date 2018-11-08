package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.AnneScolaire;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.AnneScolaireRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("api/anneeScolaire")
public class AnneScolaireController {
	@Autowired
	AnneScolaireRepository anneScolaireRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public AnneScolaire saveAnneeScolaire(@RequestBody AnneScolaire anneScolaire)
	{
		return anneScolaireRepository.save(anneScolaire);
	}
	@PutMapping("/update/{id}")
	public AnneScolaire updateAnneScolaire(@PathVariable(value="id") int code, @RequestBody AnneScolaire anneScolaireDetails) {
		AnneScolaire anneScolaire = anneScolaireRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("anneeScolaire", "code", code));
		anneScolaire.setDateDebut(anneScolaireDetails.getDateDebut());
		anneScolaire.setDateFin(anneScolaireDetails.getDateFin());
		anneScolaire.setStatut(anneScolaireDetails.getStatut());
		return anneScolaireRepository.save(anneScolaire);
	}

}
