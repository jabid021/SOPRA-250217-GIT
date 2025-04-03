package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Admin;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

public class DAOUtilisateur implements IDAOUtilisateur {

	@Override
	public List<Utilisateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Utilisateur>  utilisateurs = em.createQuery("FROM Utilisateur").getResultList();

		em.close();
		return utilisateurs;
	}

	@Override
	public Utilisateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Utilisateur utilisateur = em.find(Utilisateur.class, id);

		em.close();
		return utilisateur;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		utilisateur = em.merge(utilisateur);

		em.getTransaction().commit();
		em.close();
		return utilisateur;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Utilisateur utilisateur = em.find(Utilisateur.class,id);
		em.getTransaction().begin();

		em.remove(utilisateur);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Utilisateur findByLoginAndPassword(String login, String password) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Utilisateur utilisateur=null;
		try {
		  utilisateur = em.createQuery("SELECT u FROM Utilisateur u where u.login=:login and u.password=:password",Utilisateur.class).setParameter("login", login).setParameter("password",password).getSingleResult();
		}catch(Exception e) {}
		
		em.close();
		return utilisateur;
	}

	@Override
	public List<Admin> findAllAdmin() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Admin> utilisateurs = em.createQuery("FROM Admin").getResultList();

		em.close();
		return utilisateurs;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Formateur>  utilisateurs = em.createQuery("FROM Formateur").getResultList();

		em.close();
		return utilisateurs;
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Stagiaire>  utilisateurs = em.createQuery("FROM Stagiaire").getResultList();

		em.close();
		return utilisateurs;
	}
	

	

	

}
