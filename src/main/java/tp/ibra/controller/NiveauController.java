package tp.ibra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Niveau;
import tp.ibra.repository.NiveauRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/niveau")
public class NiveauController {
 @Autowired
 private NiveauRepository niveauRepository;
 	@RequestMapping(value="/all", method=RequestMethod.GET)
  public ResponseEntity<Collection<Niveau>> getAllNiveau(){
	  return new ResponseEntity<Collection<Niveau>>(niveauRepository.findAll(),HttpStatus.OK);
  }
}
