package transport.test;

import javax.persistence.EntityManager;

import transport.context.Singleton;

public class DemoDAO {

	public static void main(String[] args) {

	/*	Compagnie comp1 = new Compagnie("SNCF");
		Compagnie comp2 = new Compagnie("SNCF2");
		//Singleton.getInstance().getDaoCompagnie().save(comp1);
		//Singleton.getInstance().getDaoCompagnie().save(comp2);

		Moto moto = new Moto("Honda","attributMoto");
		Voiture voiture = new Voiture("BMW",5);
		
		Chien chien = new Chien("blanc","un autre attribut");
		Lion lion = new Lion("orange","un attribut");
*/
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		/*em.persist(chien);
		em.persist(lion);
		em.persist(moto);
		em.persist(voiture);*/
		em.getTransaction().commit();
		
	/*	System.out.println("All Transport");
		em.createQuery("from Transport").getResultList();
		System.out.println("--------");
		System.out.println("All BUS");
		em.createQuery("from Bus").getResultList();
	*/	

		
	/*	System.out.println("All Animals");
		List<Animal> a = em.createQuery("from Animal").getResultList();
		System.out.println("--------");
		System.out.println("All Chien");
		List<Chien> a2 = em.createQuery("from Chien").getResultList();
	*/	
		
	/*	System.out.println("All Vehicules");
		em.createQuery("from Vehicule").getResultList();
		System.out.println("--------");
		System.out.println("All Voiture");
		em.createQuery("from Voiture").getResultList();
		
	*/	

/*
		for(Transport t : Singleton.getInstance().getDaoTransport().findAll()) 
		{
			System.out.println(t);
		}

		for(Arret a : Singleton.getInstance().getDaoArret().findAll()) 
		{
			System.out.println(a);
		}


		System.out.println(Singleton.getInstance().getDaoPassager().findById(1));
		System.out.println(Singleton.getInstance().getDaoBillet().findById(1));
*/
		Singleton.getInstance().closeEmf();
	}

}
