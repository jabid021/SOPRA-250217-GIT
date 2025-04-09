package eshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class })
@Transactional
@Rollback(true)
public class DAOProduitTest {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	
	
	
	
	@Test
	public void injectDAOProduit() 
	{
		//Arrange
		//Act
		//Assert
		assertNotNull(daoProduit);
	}
	
	
	@Test
	public void findbyIdProduit() 
	{
		//Arrange
		//Act
		//Assert
	}
	
	@Test
	public void insertProduit() 
	{
		//Arrange
		Fournisseur fournisseur = new Fournisseur("Abid","Jordan","AJC");
		fournisseur = (Fournisseur) daoPersonne.save(fournisseur);
		Produit produit = new Produit("libelle",2000.50,fournisseur);
		Produit produitBdd;
		//Act
		produitBdd = daoProduit.save(produit);
	
		//Assert 
		assertNotNull(produitBdd);
		assertNotNull(produitBdd.getId());
		assertEquals("libelle", produitBdd.getLibelle());
		assertTrue(2000.50==produitBdd.getPrix());
		assertNotNull(produitBdd.getVendeur());
		assertTrue(fournisseur.getId()==produitBdd.getVendeur().getId());
	
	}

	
	@Test
	public void deleteProduit() 
	{
		//Arrange
		//Act
		//Assert
	}
	
	
	
}
