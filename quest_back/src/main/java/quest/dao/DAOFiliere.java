package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Filiere;

public class DAOFiliere implements IDAOFiliere {

	@Override
	public List<Filiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Filiere>  filieres = em.createQuery("FROM Filiere").getResultList();

		em.close();
		return filieres;
	}

	@Override
	public Filiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Filiere filiere = em.find(Filiere.class, id);

		em.close();
		return filiere;
	}

	@Override
	public Filiere save(Filiere filiere) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		filiere = em.merge(filiere);

		em.getTransaction().commit();
		em.close();
		return filiere;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Filiere filiere = em.find(Filiere.class,id);
		em.getTransaction().begin();

		em.remove(filiere);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Filiere findByIdWithModules(Integer idFiliere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Filiere  filiere = em.createQuery("SELECT f FROM Filiere f left join fetch f.modules",Filiere.class).getSingleResult();

		em.close();
		return filiere;
	}

	@Override
	public Filiere findByIdWithStagiaires(Integer idFiliere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Filiere  filiere = em.createQuery("SELECT f FROM Filiere f left join fetch f.stagiaires",Filiere.class).getSingleResult();

		em.close();
		return filiere;
	}
	

	

	

}
