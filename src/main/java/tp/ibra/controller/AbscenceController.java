package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Abscence;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.AbscenceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/abscences")
public class AbscenceController {
@Autowired
private AbscenceRepository abscenceRepository;

@RequestMapping(value="/save", method = RequestMethod.POST)
private Abscence saveAbscence(@RequestBody Abscence abscence) {
	return abscenceRepository.save(abscence);
}
@PutMapping("/update/{id}")
public Abscence updateAbscence(@PathVariable(value = "id") int code, @RequestBody Abscence AbscenceDetails){
	Abscence abscence = abscenceRepository.findById(code)
			.orElseThrow(() -> new ResourceNotFoundException("abscence", "code", code));
	abscence.setCommentaire(AbscenceDetails.getCommentaire());
	abscence.setType(AbscenceDetails.getType());
	abscence.setSceanceCours(AbscenceDetails.getSceanceCours());
	
	return abscenceRepository.save(abscence);
}
}
