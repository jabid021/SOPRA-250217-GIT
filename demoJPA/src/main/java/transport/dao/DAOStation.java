package transport.dao;

import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Station;

public class DAOStation implements IDAO<Station,Integer> {

	@Override
	public List<Station> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Station> stations = em.createQuery("FROM Station").getResultList();

		em.close();
		return stations;
	}

	@Override
	public Station findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Station station = em.find(Station.class, id);

		em.close();
		return station;
	}

	@Override
	public Station save(Station station) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		station = em.merge(station);

		em.getTransaction().commit();
		em.close();
		return station;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Station station = em.find(Station.class,id);
		em.getTransaction().begin();

		em.remove(station);

		em.getTransaction().commit();
		em.close();
	}

}
