package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Admin;
import fr.formation.model.Formateur;
import fr.formation.model.Stagiaire;
import fr.formation.model.Utilisateur;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtilisateurRepository implements QuestRepositoryBase<Utilisateur> {
	public Optional<Utilisateur> findByLogin(String login) {
		return this.find("login", login).firstResultOptional();
	}

	public Utilisateur findByLoginAndPassword(String login,String password) {
		return this.find("login = ?1 and password = ?2", login, password).firstResult();
	}

	public List<Admin> findAllAdmin() {
		return this.find("from Admin").list();
	}

	public List<Formateur> findAllFormateur() {
		return this.find("from Formateur").list();
	}

	public List<Stagiaire> findAllStagiaire() {
		return this.find("from Stagiaire").list();
	}

	public List<Stagiaire> findAllStagiaireDisponibles() {
		return this.find("select s from Stagiaire s left join s.ordinateur o where o is null").list();
	}
}
	


