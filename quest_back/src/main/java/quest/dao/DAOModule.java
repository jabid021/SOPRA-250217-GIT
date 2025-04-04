package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Module;

public class DAOModule implements IDAOModule {

	@Override
	public List<Module> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Module>  patients = em.createQuery("FROM Module").getResultList();

		em.close();
		return patients;
	}

	@Override
	public Module findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Module patient = em.find(Module.class, id);

		em.close();
		return patient;
	}

	@Override
	public Module save(Module module) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		module = em.merge(module);

		em.getTransaction().commit();
		em.close();
		return module;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Module patient = em.find(Module.class,id);
		em.getTransaction().begin();

		em.remove(patient);

		em.getTransaction().commit();
		em.close();
	}
	

	

	

}
