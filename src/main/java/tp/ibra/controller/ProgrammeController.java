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

import tp.ibra.entities.Programme;
import tp.ibra.repository.ProgrammeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/programme")
public class ProgrammeController {
	@Autowired
	ProgrammeRepository programmeRepository;
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Programme saveProgramme(@RequestBody Programme programme)
	{
		return programmeRepository.save(programme);
	}
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Collection<Programme>> getAllProgramme(){
		return new ResponseEntity<Collection<Programme>>(programmeRepository.findAll(),HttpStatus.OK);
	}

}
