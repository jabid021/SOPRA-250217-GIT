package transport.dao;

import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Compagnie;

public class DAOCompagnie implements IDAO<Compagnie,Integer> {

	@Override
	public List<Compagnie> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Compagnie> compagnies = em.createQuery("FROM Compagnie").getResultList();

		em.close();
		return compagnies;
	}

	@Override
	public Compagnie findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Compagnie compagnie = em.find(Compagnie.class, id);

		em.close();
		return compagnie;
	}

	@Override
	public Compagnie save(Compagnie compagnie) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		compagnie = em.merge(compagnie);

		em.getTransaction().commit();
		em.close();
		return compagnie;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Compagnie compagnie = em.find(Compagnie.class,id);
		em.getTransaction().begin();

		em.remove(compagnie);

		em.getTransaction().commit();
		em.close();
	}

}
