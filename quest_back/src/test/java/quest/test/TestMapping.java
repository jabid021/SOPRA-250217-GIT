package quest.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Module;

public class TestMapping {

	public static void main(String[] args) {
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		
		Matiere matiere1 = em.find(Matiere.class, 1);
		Matiere matiere2 = em.find(Matiere.class, 2);
		Matiere matiere3 = em.find(Matiere.class, 3);
		
		Filiere filiere = em.find(Filiere.class, 1);
		
		Module module1 = new Module(4142,3,filiere,matiere1);
		Module module2 = new Module(1234,2,filiere,matiere2);
		Module module3 = new Module(7894,5,filiere,matiere3);
		
		em.getTransaction().begin();
		
		em.persist(module1);
		em.persist(module2);
		em.persist(module3);
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
	}

}
