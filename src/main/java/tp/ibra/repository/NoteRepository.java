package tp.ibra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.ibra.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
