package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere,Integer>{

	@Query("SELECT m from Matiere m where m.libelle=:libelle")
	public Matiere findByLib(@Param("libelle") String libelle);
}
	