package transport.dao;

import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Arret;

public class DAOArret implements IDAO<Arret,Integer> {

	@Override
	public List<Arret> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Arret> arrets = em.createQuery("FROM Arret").getResultList();

		em.close();
		return arrets;
	}

	@Override
	public Arret findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Arret arret = em.find(Arret.class, id);

		em.close();
		return arret;
	}

	@Override
	public Arret save(Arret arret) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		arret = em.merge(arret);

		em.getTransaction().commit();
		em.close();
		return arret;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Arret arret = em.find(Arret.class,id);
		em.getTransaction().begin();

		em.remove(arret);

		em.getTransaction().commit();
		em.close();
	}

}
