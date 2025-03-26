package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import eshop.context.Singleton;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

public class DAOPersonne implements IDAO<Personne,Integer> {

	@Override
	public List<Personne> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Personne>  personnes = em.createQuery("FROM Personne").getResultList();

		em.close();
		return personnes;
	}

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Personne personne = em.find(Personne.class, id);

		em.close();
		return personne;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		personne = em.merge(personne);

		em.getTransaction().commit();
		em.close();
		return personne;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class,id);
		em.getTransaction().begin();

		em.remove(personne);

		em.getTransaction().commit();
		em.close();
	}
	
	public List<Client> findAllClient() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Client>  clients = em.createQuery("FROM Client").getResultList();

		em.close();
		return clients;
	}
	

	public List<Fournisseur> findAllFournisseur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Fournisseur>  fournisseurs = em.createQuery("FROM Fournisseur").getResultList();

		em.close();
		return fournisseurs;
	}
	
	public Client findByIdWithAchats(Integer idClient) 
	{
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("SELECT c FROM Client c LEFT JOIN FETCH c.achats where c.id = :id");
		query.setParameter("id", idClient);
		Client client = (Client) query.getSingleResult();

		em.close();
		return client;
		
	}
	
	
	public Fournisseur findByIdWithStock(Integer idFournisseur) 
	{
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Fournisseur fournisseur =em.createQuery("SELECT f FROM Fournisseur f LEFT JOIN FETCH f.stock where f.id = :id",Fournisseur.class).setParameter("id", idFournisseur).getSingleResult();

		em.close();
		return fournisseur;
		
	}
	

}
