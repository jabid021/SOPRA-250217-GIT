package transport.test;

import java.time.LocalDate;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import transport.model.Adresse;
import transport.model.Billet;
import transport.model.Bus;
import transport.model.Civilite;
import transport.model.Ligne;
import transport.model.Passager;
import transport.model.Station;
import transport.model.Train;

public class TestJPA {

	public static void main(String[] args) {
		
		
		
		Station station1 = new Station("Auber");
		Collections.addAll(station1.getLignes(), Ligne.L1,Ligne.L13);
		
		Station station2 = new Station("La Défense");
		station2.getLignes().add(Ligne.L2);
		station2.getLignes().add(Ligne.L13);
		
		
		Bus bus1 = new Bus(LocalDate.parse("2022-01-01"),30);
		Train train1 = new Train(LocalDate.parse("2022-01-01"),"Gris");
		
		bus1.getStations().add(station1);
	
		
		train1.getStations().add(station1);
		train1.getStations().add(station2);
		
		
		Billet billet1 = new Billet(LocalDate.now(), 49.99, true,bus1);
		Billet billet2 = new Billet(LocalDate.parse("2000-01-01"), 0, false,train1);
		
		
		Passager passager1 = new Passager("John","Doe",Civilite.homme,billet1);
		passager1.setAdresse(new Adresse("1","rue de paris","Paris","75009"));
		
		Passager passager2 = new Passager("Jane","Doe",Civilite.femme,billet2);

		
		
		
		
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			//persist => insert bdd
		
			em.persist(station1);
			em.persist(station2);
		
			em.persist(bus1);
			em.persist(train1);
		
	
			em.persist(billet1);
			em.persist(billet2);
			
			em.persist(passager1);
			em.persist(passager2);
			
			
			
		
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Passager.class, 1));
			
		em.close();
		emf.close();
		
		
		
		
	}

}
