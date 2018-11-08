package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Administration;
import tp.ibra.entities.Tuteur;
import tp.ibra.exceptions.ResourceNotFoundException;
import tp.ibra.repository.AdministrationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/administration")
public class AdministrationController {
	@Autowired
	private AdministrationRepository administrationRepository;
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Administration saveAdministration (@RequestBody Administration administration) {
		return administrationRepository.save(administration);
	}
	@PutMapping("/update/{id}")
	public Administration updateAdministration(@PathVariable(value = "id") int code, @RequestBody Administration administrationDetails){
		Administration administration = administrationRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("administration", "code", code));
		
		administration.setNom(administrationDetails.getNom());
		administration.setPrenom(administrationDetails.getPrenom());
		administration.setAdresse(administrationDetails.getAdresse());
		administration.setTelephone(administrationDetails.getTelephone());
		administration.setEmail(administrationDetails.getEmail());
		administration.setPoste(administrationDetails.getPoste());
		return administrationRepository.save(administration);
	}
}
