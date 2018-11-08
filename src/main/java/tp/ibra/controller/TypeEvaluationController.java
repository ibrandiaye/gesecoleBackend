package tp.ibra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.TypeEvaluation;
import tp.ibra.repository.TypeEvaluationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/typeEvaluation")
public class TypeEvaluationController {
	@Autowired
	private TypeEvaluationRepository typeEvaluationRepository;
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Collection<TypeEvaluation>> getAllEvaluation() {
		return new ResponseEntity<Collection<TypeEvaluation>>(typeEvaluationRepository.findAll(), HttpStatus.OK);
	}

}
