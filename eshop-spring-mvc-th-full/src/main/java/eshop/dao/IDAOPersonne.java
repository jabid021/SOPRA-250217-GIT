package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

public interface IDAOPersonne extends JpaRepository<Personne,Integer>{
	@Query("FROM Client")
	public List<Client> findAllClient();

	@Query("FROM Fournisseur")
	public List<Fournisseur> findAllFournisseur();

	@Query("SELECT c FROM Client c LEFT JOIN FETCH c.achats where c.id = :id")
	public Client findByIdWithAchats(@Param("id") Integer idClient);

	@Query("SELECT f FROM Fournisseur f LEFT JOIN FETCH f.stock where f.id = :id")
	public Fournisseur findByIdWithStock(@Param("id") Integer idFournisseur);
}
