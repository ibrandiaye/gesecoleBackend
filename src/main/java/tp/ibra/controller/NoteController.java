package tp.ibra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.ibra.entities.Note;
import tp.ibra.repository.NoteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/note")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Note saveNote(@RequestBody Note note) {
		return noteRepository.save(note);
	}
}
