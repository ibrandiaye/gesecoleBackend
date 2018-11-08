package tp.ibra.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.entities.Classe;
import tp.ibra.repository.ClasseRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/classe")
public class ClasseController {
	@Autowired
	private ClasseRepository classeRepository;
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Classe saveClasse(@RequestBody Classe classe) {
		return classeRepository.save(classe);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<Collection<Classe>> getAllClasse() {
		return new ResponseEntity<Collection<Classe>>(classeRepository.findAll(sortByCodeDesc()),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public Classe updateClasse(@PathVariable(value="id") int code, @RequestBody Classe classeDetails) {
		Classe classe = classeRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("classe","code",code));
		classe.setNom(classeDetails.getNom());
		classe.setNiveau(classeDetails.getNiveau());
		return classeRepository.save(classe);
	}
	@RequestMapping(value="/classes/{nom}",method=RequestMethod.GET)
	public ResponseEntity<List<Classe>> getClasseByProgramme(@PathVariable("nom") String nom){
		return new ResponseEntity<List<Classe>>(classeRepository.getClassesByProgramme(nom),HttpStatus.OK);
	}
	private Sort sortByCodeDesc() {
		return new Sort(Sort.Direction.DESC,"code");
	}

}
