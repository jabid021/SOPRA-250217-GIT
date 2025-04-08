package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Module;

@Repository
@Transactional
public class DAOModule implements IDAOModule {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Module> findAll() {
		return em.createQuery("FROM Module").getResultList();
	}

	@Override
	public Module findById(Integer id) {
		return em.find(Module.class, id);
	}

	@Override
	public Module save(Module module) {
		return em.merge(module);
	}

	@Override
	public void delete(Integer id) {
		Module patient = em.find(Module.class,id);
		em.remove(patient);
	}
	

	

	

}
