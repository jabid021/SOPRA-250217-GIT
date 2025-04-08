package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Personne> findAll() {
		return em.createQuery("FROM Personne").getResultList();
	}

	@Override
	public Personne findById(Integer id) {
		return em.find(Personne.class, id);
	}

	@Override
	public Personne save(Personne personne) {
		return em.merge(personne);
	}

	@Override
	public void delete(Integer id) {
		Personne personne = em.find(Personne.class,id);
		em.remove(personne);
	}

	public List<Client> findAllClient() {
		return em.createQuery("FROM Client").getResultList();
	}


	public List<Fournisseur> findAllFournisseur() {
		return em.createQuery("FROM Fournisseur").getResultList();
	}

	public Client findByIdWithAchats(Integer idClient) 
	{
		Query query = em.createQuery("SELECT c FROM Client c LEFT JOIN FETCH c.achats where c.id = :id");
		query.setParameter("id", idClient);
		Client client = (Client) query.getSingleResult();
		return client;
	}


	public Fournisseur findByIdWithStock(Integer idFournisseur) 
	{
		return em.createQuery("SELECT f FROM Fournisseur f LEFT JOIN FETCH f.stock where f.id = :id",Fournisseur.class).setParameter("id", idFournisseur).getSingleResult();
	}


}
