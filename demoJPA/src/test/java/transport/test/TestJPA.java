package transport.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import transport.model.Adresse;
import transport.model.Billet;
import transport.model.Civilite;
import transport.model.Passager;

public class TestJPA {

	public static void main(String[] args) {
		
		Passager passager1 = new Passager("John","Doe",Civilite.homme);
		passager1.setAdresse(new Adresse("1","rue de paris","Paris","75009"));
		
		Passager passager2 = new Passager("Jane","Doe",Civilite.femme);

		
		Billet billet1 = new Billet(LocalDate.now(), 49.99, true);
		Billet billet2 = new Billet(LocalDate.parse("2000-01-01"), 0, false);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			//persist => insert bdd
			em.persist(passager1);
			em.persist(passager2);
			em.persist(billet1);
			em.persist(billet2);
		
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Passager.class, 1));
			
		em.close();
		emf.close();
		
		
		
		
	}

}
