package transport.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import transport.context.Singleton;
import transport.model.Arret;
import transport.model.Passager;
import transport.model.Station;
import transport.model.Train;

public class TestMethodesEM {



	public static void demo() 
	{
		Station station1 = new Station("Nouvelle Station");
		Train train1 = new Train(LocalDate.parse("2022-01-01"),"Gris");

		//Station station2 = new Station("Auber");

		//listes des methodes d'un EM
			//persist(x) => ne fait que de l'insert (plante si on lui donne un id en autoincrement)
				//x est managed
			//y=merge(x)
					//=> si l'objet possede ne possede pas d'id ou un id inconnu dans la bdd => insert
					//=> si l'objet possede un id existant => update
				//x n'est pas managed, y est managed
			//x= find => findById 
					//x est managed
			//remove(x) => remove
					//x doit etre managed
			// em.createQuery => findAll ou tout autre requete SELECT
		
		//Pour toute modification dans la bdd (insert/update/delete) il faut encadrer le code par un transaction.begin et commit
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
			Station stationCopie = em.merge(station1);
			Train trainCopie = em.merge(train1);
			Arret arret = new Arret(LocalTime.parse("15:05:00"),stationCopie,trainCopie);
			arret=em.merge(arret);
			//em.remove(station2);

		em.getTransaction().commit();
		
		System.out.println(station1); // station1 est la version qu'on veut save, qui n'a pas encore d'idet qui n'est pas managed
		System.out.println(stationCopie); //stationCopie est la version managed avec un id provenant de la bdd
		//em.find(Station.class, 1);
		//JavaProgramingQueryLanguage
		
		
		 List<Passager> passagers = em.createQuery("FROM Passager").getResultList();
		 System.out.println("Liste des passages :" );
		 if(passagers.isEmpty()) {System.out.println("Aucun passager");}
		 for(Passager p : passagers) 
		 {
			 System.out.println(p);
		 }
		 
		 
		System.out.println(em.createQuery("FROM Train").getResultList());
		em.close();
	}

	public static void main(String[] args) {
		Singleton.getInstance();

		demo();

		Singleton.getInstance().closeEmf();	
	}




}
