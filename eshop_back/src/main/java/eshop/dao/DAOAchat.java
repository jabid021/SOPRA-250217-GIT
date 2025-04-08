package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Achat;

@Repository
@Transactional
public class DAOAchat implements IDAOAchat {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Achat> findAll() {
		return em.createQuery("FROM Achat").getResultList();
	}

	@Override
	public Achat findById(Integer id) {
		return em.find(Achat.class, id);
	}

	@Override
	public Achat save(Achat achat) {
		return em.merge(achat);
	}

	@Override
	public void delete(Integer id) {
		Achat achat = em.find(Achat.class,id);
		em.remove(achat);
	}

}
