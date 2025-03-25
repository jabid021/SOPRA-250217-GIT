package transport.dao;

import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Billet;

public class DAOBillet implements IDAO<Billet,Integer> {

	@Override
	public List<Billet> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Billet>  billets = em.createQuery("FROM Billet").getResultList();

		em.close();
		return billets;
	}

	@Override
	public Billet findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Billet billet = em.find(Billet.class, id);

		em.close();
		return billet;
	}

	@Override
	public Billet save(Billet billet) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		billet = em.merge(billet);

		em.getTransaction().commit();
		em.close();
		return billet;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Billet billet = em.find(Billet.class,id);
		em.getTransaction().begin();

		em.remove(billet);

		em.getTransaction().commit();
		em.close();
	}

}
