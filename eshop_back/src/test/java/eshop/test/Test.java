package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Personne personne1 = new Client("Abid","Jordan",31,LocalDate.parse("1993-05-01"),new Adresse("6","rue rougemont","75009","Paris"));
		Personne personne2 = new Fournisseur("Abid","Charly","AJC");
		
		Produit produit1 = new Produit("Formation Algo",1200);
		Produit produit2 = new Produit("Formation Spring",1750.99);
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	
		
		em.persist(client);
		em.persist(fournisseur);
		em.persist(produit1);
		em.persist(produit2);
		
		em.getTransaction().commit();
			
		
		//System.out.println(em.find(Client.class, 1));
		
		em.close();
		emf.close();

	}

}
