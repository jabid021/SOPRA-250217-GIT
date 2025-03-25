package transport.dao;

import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Transport;

public class DAOTransport implements IDAO<Transport,Integer> {

	@Override
	public List<Transport> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("FROM Transport").getResultList();

		em.close();
		return transports;
	}

	@Override
	public Transport findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Transport transport = em.find(Transport.class, id);

		em.close();
		return transport;
	}

	@Override
	public Transport save(Transport transport) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		transport = em.merge(transport);

		em.getTransaction().commit();
		em.close();
		return transport;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Transport transport = em.find(Transport.class,id);
		em.getTransaction().begin();

		em.remove(transport);

		em.getTransaction().commit();
		em.close();
	}

}
