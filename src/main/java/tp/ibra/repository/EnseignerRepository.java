package tp.ibra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.ibra.entities.Enseigner;
import tp.ibra.entities.EnseignerPk;

public interface EnseignerRepository extends JpaRepository<Enseigner, EnseignerPk> {

}
