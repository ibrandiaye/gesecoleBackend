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

import tp.ibra.entities.Evaluation;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.EvaluationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/evaluation")
public class EvaluationController {
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Evaluation saveEvaluation(@RequestBody Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<Collection<Evaluation>> getAllEvaluation(){
		return new ResponseEntity<Collection<Evaluation>>(evaluationRepository.findAll(),HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public Evaluation updateEvaluation(@PathVariable(value = "id") int code, @RequestBody Evaluation evaluationDetails){
	Evaluation evaluation	= evaluationRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("evaluation", "code", code));
	evaluation.setLibelle(evaluationDetails.getLibelle());
	evaluation.setSemestre(evaluationDetails.getSemestre());
	evaluation.setDate(evaluationDetails.getDate());
	evaluation.setMatiere(evaluationDetails.getMatiere());
	evaluation.setType_evaluation(evaluationDetails.getType_evaluation());
	
		
		return evaluationRepository.save(evaluation);
	}
	
}
