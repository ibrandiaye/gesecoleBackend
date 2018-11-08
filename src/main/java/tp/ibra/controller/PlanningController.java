package tp.ibra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Planning;
import tp.ibra.repository.PlanningRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/planning")
public class PlanningController {
	@Autowired
	private PlanningRepository planningRepository;
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Planning savePlanning(@RequestBody Planning planning) {
		return planningRepository.save(planning);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<Collection<Planning>> getAllPlanning(){
		return new ResponseEntity<Collection<Planning>>(planningRepository.findAll(), HttpStatus.OK);
	}
}
