package eshop.test;

import java.time.LocalDate;

import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

	public static void main(String[] args) {

		Fournisseur fournisseur1 = new Fournisseur("Abid", "Charly", "AJC");

		Produit produit1 = new Produit("Formation Algo", 1200, fournisseur1);
		Produit produit2 = new Produit("Formation Spring", 1750.99, fournisseur1);

		Client client1 = new Client("Abid", "Jordan", 31, LocalDate.parse("1993-05-01"),
				new Adresse("6", "rue rougemont", "75009", "Paris"));

		Achat achat1 = new Achat(LocalDate.parse("2020-01-01"), 2, client1, produit1);
		Achat achat2 = new Achat(LocalDate.parse("2020-03-01"), 1, client1, produit2);

		// Collections.addAll(client1.getAchats(), achat1,achat2);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(fournisseur1);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(client1);
		em.persist(achat1);
		em.persist(achat2);
		em.getTransaction().commit();

		em.close();

		emf.close();

	}

}
