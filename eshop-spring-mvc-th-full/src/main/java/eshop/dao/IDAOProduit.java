package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit,Integer> {

	@Query("SELECT p FROM Produit p where p.libelle = :lib")
	public List<Produit> findByLib(@Param("lib") String libelle);
	
	public List<Produit> findByLibelle(String libelle);
	
	public List<Produit> findByPrixBetween(double a,double b);
	
	public List<Produit> findByLibelleContaining(String recherche);

	@Query("SELECT p FROM Produit p JOIN FETCH p.ventes where p.id=:id ")
	public Produit findByIdWithVentes(@Param("id")Integer idProduit);
	
}


