package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Filiere;

@Repository
@Transactional
public class DAOFiliere implements IDAOFiliere {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Filiere> findAll() {
		return em.createQuery("FROM Filiere").getResultList();
	}

	@Override
	public Filiere findById(Integer id) {
		return em.find(Filiere.class, id);
	}

	@Override
	public Filiere save(Filiere filiere) {
		return em.merge(filiere);
	}

	@Override
	public void delete(Integer id) {
		Filiere filiere = em.find(Filiere.class,id);
		em.remove(filiere);
	}

	@Override
	public Filiere findByIdWithModules(Integer idFiliere) {
		return em.createQuery("SELECT f FROM Filiere f left join fetch f.modules where f.id=:id",Filiere.class).setParameter("id", idFiliere).getSingleResult();
	}

	@Override
	public Filiere findByIdWithStagiaires(Integer idFiliere) {
		return em.createQuery("SELECT f FROM Filiere f left join fetch f.stagiaires where f.id=:id",Filiere.class).setParameter("id", idFiliere).getSingleResult();
	}






}
