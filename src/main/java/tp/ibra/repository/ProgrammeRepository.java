package tp.ibra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.ibra.entities.Programme;

public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {

}
