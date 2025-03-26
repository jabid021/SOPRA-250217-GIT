package hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import hopital.context.Singleton;
import hopital.dao.IDAOVisite;
import hopital.model.Visite;

public class DAOVisite implements IDAOVisite {

	@Override
	public List<Visite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Visite>  visites = em.createQuery("FROM Visite").getResultList();

		em.close();
		return visites;
	}

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Visite visite = em.find(Visite.class, id);

		em.close();
		return visite;
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		visite = em.merge(visite);

		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class,id);
		em.getTransaction().begin();

		em.remove(visite);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Visite> findByPatient(Integer idPatient) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	

}
