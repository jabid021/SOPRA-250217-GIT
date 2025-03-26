package transport.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import transport.context.Singleton;
import transport.model.Billet;
import transport.model.Passager;
import transport.model.Transport;

public class TestRequetes {

	
	
	
	public static void main(String[] args) {
		
		//Quand on fait une query, on peut utiliser getSingleResult / getResultList
		//getResultList peut return : tableau complet, tableau vide [];
		//getSingleResult peut return  : l'objet recherché, si plusieurs objets => exception, si 0 objet => exception
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		System.out.println("TOUS LES PASSAGERS");
		List<Passager> passagers = em.createQuery("from Passager").getResultList();
		System.out.println(passagers);
		
		System.out.println("--------------------------------");
		System.out.println("BILLETS > 40€");
		List<Billet> billets = em.createQuery("SELECT b from Billet b where b.prix>40").getResultList();
		System.out.println(billets);
		
		System.out.println("--------------------------------");
		System.out.println("BILLETS NON VALIDES");
		List<Billet> billets2 = em.createQuery("SELECT b from Billet b where b.valide=false").getResultList();
		System.out.println(billets2);
		
		
		System.out.println("--------------------------------");
		System.out.println("BILLETS TRAJET EN 2025");
		List<Billet> billets3 = em.createQuery("SELECT b from Billet b where b.dateTrajet like '2025%' ").getResultList();
		System.out.println(billets3);
		
		
		System.out.println("--------------------------------");
		System.out.println("BILLETS D'UN PASSAGER 'DOE' ");
		
		/*SELECT * from billet join traveler on traveler.billet=billet.id where traveler.lastname='DOE';*/
		List<Billet> billets4 = em.createQuery("SELECT b from Billet b where b.voyageur.nom='Doe'").getResultList();
		System.out.println(billets4);
		
		
		System.out.println("--------------------------------");
		System.out.println("BILLETS D'UN PASSAGER 'DOE' avec une VRAIE Requete SQL ");
		
		List<Billet> billets5 = em.createNativeQuery("SELECT * from billet join traveler on traveler.billet=billet.id where traveler.lastname='DOE'",Billet.class).getResultList();
		System.out.println(billets5);
		
				
		
		
		
		double x = 40;

		System.out.println("--------------------------------");
		System.out.println("BILLETS >= x");
		
		Query requete = em.createQuery("SELECT b from Billet b where b.prix>= :price");
		//requete.setParameter(1, x);
		requete.setParameter("price", x);
		List<Billet> billets6 = requete.getResultList();
		
		List<Billet> billets7 = em.createQuery("SELECT b FROM Billet b where b.prix>= :price").setParameter("price", x).getResultList();
		System.out.println(billets6);
		System.out.println(billets7);
		
		
		
		System.out.println("--------------");
		
		Transport recherche = em.createQuery("SELECT t FROM Transport t JOIN FETCH t.billets where t.id=1",Transport.class).getSingleResult();	
		em.close();
		
		
		System.out.println("Informations du transport : "+recherche.getId());
		System.out.println("Liste de ses billets :");
		System.out.println(recherche.getBillets());
		
		System.out.println(Singleton.getInstance().getDaoStation().findById(1));
		
		System.out.println("\n\n\n----------\n\n\n");
		List<Transport> allTransports = Singleton.getInstance().getDaoTransport().findAll();
		
		for(Transport t : allTransports)
		{
			System.out.println("Id du transport : "+t.getId());
			System.out.println("Liste des billets pour ce transport : "+t.getBillets());
			System.out.println("\n");
			
		}
		
		Singleton.getInstance().closeEmf();		
		
	}
}
