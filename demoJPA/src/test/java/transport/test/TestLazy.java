package transport.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Transport;

public class TestLazy {

	//DEMO SUR LES TRANSPORTS 


	//Acces aux billets APRES le em.close() ❌
	//Impossibe de faire des filtres sur le prix des billets ❌
	public static void showLazy() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("from Transport").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t.getBillets());
		}

	}



	//Acces aux billets APRES le em.close() ❌
	//Impossibe de faire des filtres sur le prix des billets ✔
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ❌
	public static void showFilter() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT t from Transport t JOIN t.billets b where b.prix>=0").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t);
			//System.out.println(t.getBillets());
		}

	}



	//Acces aux billets APRES le em.close() ❌
	//Impossibe de faire des filtres sur le prix des billets ✔
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ✔
	public static void showFilterNoDoublons() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t JOIN t.billets b where b.prix>=0").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billes du transport "+t.getId());
			System.out.println(t);
			//System.out.println(t.getBillets());
		}

	}

	//Acces aux billets APRES le em.close() ❌
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ✔
	//join ne retourne QUE les transport ayant des Billets ❌
	public static void showWithBilletNoDoublonsOnlyBillet() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t JOIN t.billets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t);
			//System.out.println(t.getBillets());
		}

	}


	//Acces aux billets APRES le em.close() ❌
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ✔
	//join ne retourne QUE les transport ayant des Billets ✔
	public static void showWithLeftBilletNoDoublons() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t LEFT JOIN t.billets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t);
			//System.out.println(t.getBillets());
		}

	}

	//Acces aux billets APRES le em.close() ✔
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ✔
	//join ne retourne QUE les transport ayant des Billets ❌
	public static void showWithBilletNoDoublonsAfterClose() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t  JOIN FETCH t.billets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t);
			System.out.println(t.getBillets());
		}

	}
	//Acces aux billets APRES le em.close() ✔
	//Les transports ayant plusieurs billets sortent avec des doublons (une ligne pour chaque billet) ✔
	//join ne retourne QUE les transport ayant des Billets ✔
	public static void showWithLeftBilletNoDoublonsAfterClose() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t LEFT JOIN FETCH t.billets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println("Liste des billets du transport "+t.getId());
			System.out.println(t);
			System.out.println(t.getBillets());
		}

	}
	
	
	public static void showWithBilletAndArretNotWorking() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t JOIN FETCH t.billets JOIN fetch t.arrets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println(t);
			System.out.println("Liste des billets du transport "+t.getId());
			
			System.out.println(t.getBillets());
			System.out.println(t.getArrets());
		}

	}
	
	
	
	public static void showWithBilletAndArretWorking() 
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Transport> transports = em.createQuery("SELECT distinct t from Transport t LEFT JOIN FETCH t.billets").getResultList();
		transports = em.createQuery("SELECT distinct t from Transport t LEFT JOIN fetch t.arrets").getResultList();
		em.close();

		for(Transport t : transports) 
		{
			System.out.println(t);
			System.out.println("Liste des billets du transport "+t.getId());
			
			System.out.println(t.getBillets());
			System.out.println(t.getArrets());
		}

	}
	
	public static void demoJPQLCount() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Integer>  nb =em.createQuery("SELECT COUNT(t) from Transport t group by t").getResultList();
		System.out.println(nb);
		em.close();

	
	}
	
	
	public static void demoJPQLCountJeTenteDesTrucs() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Object[]> result =em.createQuery("SELECT COUNT(t),MIN(t.dateFabrication) from Transport t group by Type(t) HAVING COUNT(t) > 1").getResultList();
		for(Object[]  o : result) 
		{
			System.out.println(Arrays.toString(o));
		}
		em.close();
	}
	public static void main(String[] args) {

		demoJPQLCount();

	}

}
