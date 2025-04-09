package eshop.test;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestSpringJPA {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	public void run() 
	{
		
		List<Produit> produits = daoProduit.findAll();
		System.out.println("Liste des produits : ");
		for(Produit p : produits) {System.out.println(p);}
		
		
		Fournisseur fournisseur = new Fournisseur("Abid","Jordan","AJC");
		daoPersonne.save(fournisseur);
		
		
		Produit p = new Produit("Stylo",2.50,fournisseur);
		Produit p2 = new Produit("Cahier",4.50,fournisseur);
		
		daoProduit.save(p);
		daoProduit.save(p2);
		
		/*Adresse  adresse1 = new Adresse("6","rue rougemont","75009","Paris");
		Client client1 = new Client("Abid","Jordan",30,LocalDate.parse("1993-05-01"),adresse1);
		
		daoPersonne.save(client1);
		*/
		
		System.out.println("Test fonctions DATA JPA");
		
		daoProduit.findByLib("Stylo");
		//daoProduit.find????("Stylo");
		
		//System.out.println(daoProduit.findBy?????(1,5));
		
		
		
	}
}
