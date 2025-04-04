package quest.dao;

import java.util.List;

import quest.model.Admin;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

public interface IDAOUtilisateur extends IDAO<Utilisateur,Integer>{

	public Utilisateur findByLoginAndPassword(String login,String password);
	public List<Admin> findAllAdmin();
	public List<Formateur> findAllFormateur();
	public List<Stagiaire> findAllStagiaire();
	public List<Stagiaire> findAllStagiaireDisponibles();
}
	