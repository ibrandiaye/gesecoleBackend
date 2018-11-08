package tp.ibra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Matiere;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.MatiereRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/matiere")
public class MatiereControler {
	@Autowired
	private MatiereRepository matiereRepository;
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Matiere saveMatiere(@RequestBody Matiere matiere) {
		return matiereRepository.save(matiere);
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Collection<Matiere>> getAllMatiere(){
		return new ResponseEntity<Collection<Matiere>>(matiereRepository.findAll(),HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public Matiere updateMatiere(@PathVariable(value="id")int code, @RequestBody Matiere matiereDetails) {
		Matiere matiere = matiereRepository.findById(code)
				.orElseThrow(()-> new ResourceNotFoundException("matiere", "code", code));
		matiere.setNom(matiereDetails.getNom());
		matiere.setCoefficient(matiereDetails.getCoefficient());
		matiere.setProfesseur(matiere.getProfesseur());
		
		return matiereRepository.save(matiere);
	}
	
}
