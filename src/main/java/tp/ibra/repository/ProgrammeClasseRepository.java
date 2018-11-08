package tp.ibra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.ibra.entities.ProgrammeClasse;
import tp.ibra.entities.ProgrammeClassePk;

public interface ProgrammeClasseRepository extends JpaRepository<ProgrammeClasse, ProgrammeClassePk>{

}
