package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer>{

	@Query("SELECT distinct f FROM Filiere f left join fetch f.modules")
	public List<Filiere> findAllWithModules();
	
	@Query("SELECT distinct f FROM Filiere f left join fetch f.modules where f.id=:id")
	public Filiere findByIdWithModules(@Param("id") Integer idFiliere);
	
	@Query("SELECT distinct f FROM Filiere f left join fetch f.eleves where f.id=:id")
	public Filiere findByIdWithStagiaires(@Param("id") Integer idFiliere);
}
	