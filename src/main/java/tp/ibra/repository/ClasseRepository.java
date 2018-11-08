package tp.ibra.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tp.ibra.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer>{

	@Query("select c from Classe c inner join c.programmeClasses pc inner join pc.programme p where p.nom LIKE %:x%")
	public List<Classe> getClassesByProgramme(@Param("x") String nom);
	
}
