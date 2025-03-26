package hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.model.Compte;

public class DAOCompte implements IDAOCompte {

	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Compte>  comptes = em.createQuery("FROM Compte").getResultList();

		em.close();
		return comptes;
	}

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Compte compte = em.find(Compte.class, id);

		em.close();
		return compte;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		compte = em.merge(compte);

		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class,id);
		em.getTransaction().begin();

		em.remove(compte);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Compte findByLoginAndPassword(String login, String password) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Compte compte=null;
		try {
		 compte = em.createQuery("SELECT c from Compte c where c.login=:login and c.password=:password",Compte.class).setParameter("login", login).setParameter("password", password).getSingleResult();
		}catch(Exception e) {}

		return compte;
	}
	

	

	

}
