package tp.ibra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tp.ibra.entities.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Integer>{
	@Query("select e from Eleve e inner join e.inscription  i inner join i.classe c where c.nom LIKE %:x")
	public List<Eleve>getElevesByClasse(@Param ("x") String nom);

}
