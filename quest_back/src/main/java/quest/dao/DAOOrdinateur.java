package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Ordinateur;

@Repository
@Transactional
public class DAOOrdinateur implements IDAOOrdinateur {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ordinateur> findAll() {
		return em.createQuery("FROM Ordinateur").getResultList();
	}

	@Override
	public Ordinateur findById(Integer id) {
		return em.find(Ordinateur.class, id);
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		return em.merge(ordinateur);
	}

	@Override
	public void delete(Integer id) {
		Ordinateur ordinateur = em.find(Ordinateur.class,id);
		em.remove(ordinateur);
	}







}
