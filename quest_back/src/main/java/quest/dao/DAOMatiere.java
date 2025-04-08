package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Matiere;

@Repository
@Transactional
public class DAOMatiere implements IDAOMatiere {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Matiere> findAll() {
		return em.createQuery("FROM Matiere").getResultList();
	}

	@Override
	public Matiere findById(Integer id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public Matiere save(Matiere matiere) {
		return em.merge(matiere);
	}

	@Override
	public void delete(Integer id) {
		Matiere matiere = em.find(Matiere.class,id);
		em.remove(matiere);
	}

	@Override
	public Matiere findByLib(String lib) 
	{
		return em.createQuery("SELECT m from Matiere m where m.libelle=:libelle",Matiere.class).setParameter("libelle", lib).getSingleResult();
	}



}
