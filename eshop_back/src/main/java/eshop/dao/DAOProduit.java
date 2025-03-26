package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Produit;

public class DAOProduit implements IDAO<Produit,Integer> {

	@Override
	public List<Produit> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Produit>  produits = em.createQuery("FROM Produit").getResultList();

		em.close();
		return produits;
	}

	@Override
	public Produit findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Produit produit = em.find(Produit.class, id);

		em.close();
		return produit;
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		produit = em.merge(produit);

		em.getTransaction().commit();
		em.close();
		return produit;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Produit produit = em.find(Produit.class,id);
		em.getTransaction().begin();

		em.remove(produit);

		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Produit> findByLib(String libelle) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Produit>  produits = em.createQuery("SELECT p FROM Produit p where p.libelle = :lib").setParameter("lib", libelle).getResultList();

		em.close();
		return produits;
	}
	

	public List<Produit> findByLibelleContaining(String recherche) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Produit>  produits = em.createQuery("SELECT p FROM Produit p where p.libelle like :lib").setParameter("lib", "%"+recherche+"%").getResultList();

		em.close();
		return produits;
	}

	
	public Produit findByIdWithVentes(Integer idProduit) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Produit  produit = em.createQuery("SELECT p FROM Produit p JOIN FETCH p.ventes where p.id=:id ",Produit.class).setParameter("id", idProduit).getSingleResult();

		em.close();
		return produit;
	}
	
	
}
