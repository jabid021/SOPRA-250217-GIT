package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Admin;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

@Repository
@Transactional
public class DAOUtilisateur implements IDAOUtilisateur {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Utilisateur> findAll() {
		return em.createQuery("FROM Utilisateur").getResultList();
	}

	@Override
	public Utilisateur findById(Integer id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return em.merge(utilisateur);
	}

	@Override
	public void delete(Integer id) {
		Utilisateur utilisateur = em.find(Utilisateur.class,id);
		em.remove(utilisateur);
	}

	@Override
	public Utilisateur findByLoginAndPassword(String login, String password) {
		Utilisateur utilisateur=null;
		try {
			return em.createQuery("SELECT u FROM Utilisateur u where u.login=:login and u.password=:password",Utilisateur.class).setParameter("login", login).setParameter("password",password).getSingleResult();
		}catch(Exception e) {}
		
		return utilisateur;
	}

	@Override
	public List<Admin> findAllAdmin() {
		return em.createQuery("FROM Admin").getResultList();
	}

	@Override
	public List<Formateur> findAllFormateur() {
		return em.createQuery("FROM Formateur").getResultList();
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		return em.createQuery("FROM Stagiaire").getResultList();
	}

	@Override
	public List<Stagiaire> findAllStagiaireDisponibles() {
		return em.createQuery("SELECT s FROM Stagiaire s LEFT JOIN s.ordinateur o WHERE o IS NULL").getResultList();
	}
	

	

	

}
