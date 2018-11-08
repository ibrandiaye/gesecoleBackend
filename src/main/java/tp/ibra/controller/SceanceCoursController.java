package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.SceanceCours;
import tp.ibra.repository.SceanceCoursRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/sceanceCours")
public class SceanceCoursController {
	@Autowired
	private SceanceCoursRepository coursRepository;
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public SceanceCours saveSceanceCours(@RequestBody SceanceCours cours)
	{
		return coursRepository.save(cours);
	}

}
