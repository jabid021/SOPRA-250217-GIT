package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshop.model.Produit;

@Repository
@Transactional
public class DAOProduit implements IDAOProduit {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Produit> findAll() {
		return em.createQuery("FROM Produit").getResultList();
	}

	@Override
	public Produit findById(Integer id) {
		return em.find(Produit.class, id);
	}

	@Override
	public Produit save(Produit produit) {
		return em.merge(produit);
	}

	@Override
	public void delete(Integer id) {
		Produit produit = em.find(Produit.class,id);
		em.remove(produit);
	}
	
	
	public List<Produit> findByLib(String libelle) {
		return em.createQuery("SELECT p FROM Produit p where p.libelle = :lib").setParameter("lib", libelle).getResultList();
	}
	

	public List<Produit> findByLibelleContaining(String recherche) {
		return em.createQuery("SELECT p FROM Produit p where p.libelle like :lib").setParameter("lib", "%"+recherche+"%").getResultList();
	}

	
	public Produit findByIdWithVentes(Integer idProduit) {
		return em.createQuery("SELECT p FROM Produit p JOIN FETCH p.ventes where p.id=:id ",Produit.class).setParameter("id", idProduit).getSingleResult();
	}
	
	
}
