package eshop.test;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestSpringJPA {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	
	@Autowired
	IDAOAchat daoAchat;
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
		
		Adresse  adresse1 = new Adresse("6","rue rougemont","75009","Paris");
		Client client1 = new Client("Abid","Jordan",30,LocalDate.parse("1993-05-01"),adresse1);
		
		daoPersonne.save(client1);
		
		Achat achat1 = new Achat(LocalDate.parse("2024-01-30"),2,client1,p);
		Achat achat2 = new Achat(LocalDate.parse("2025-01-30"),1,client1,p2);
		Achat achat3 = new Achat(LocalDate.parse("2026-01-30"),1,client1,p);
		
		
		daoAchat.save(achat1);
		daoAchat.save(achat2);
		daoAchat.save(achat3);
		
		System.out.println("------*Test fonctions DATA JPA*--------");

		System.out.println("Find by lib :");
		System.out.println(daoProduit.findByLib("Stylo"));	
		System.out.println("\nFind by libelle :");
		System.out.println(daoProduit.findByLibelle("Stylo"));	
		System.out.println("\nFind by prix between :");
		System.out.println(daoProduit.findByPrixBetween(1, 5));
		System.out.println("\nFind by date >=  :");
		System.out.println(daoAchat.findByDateAchatGreaterThanEqual(LocalDate.parse("2025-01-01")));
		
		
		//daoProduit.find????("Stylo");
		
		//System.out.println(daoProduit.findBy?????(1,5));
		
		
		
	}
}
