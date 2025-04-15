package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quest.model.Admin;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{

	public Utilisateur findByLoginAndPassword(String login,String password);
	@Query("from Admin")
	public List<Admin> findAllAdmin();
	@Query("from Formateur")
	public List<Formateur> findAllFormateur();
	@Query("from Stagiaire")
	public List<Stagiaire> findAllStagiaire();
	@Query("SELECT s FROM Stagiaire s LEFT JOIN s.ordinateur o WHERE o IS NULL")
	public List<Stagiaire> findAllStagiaireDisponibles();
}
	


