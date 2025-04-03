package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOUtilisateur;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOUtilisateur;
import quest.service.MatiereService;

public class Singleton {
	
	private static Singleton instance=null; 
	
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateur();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOModule daoModule = new DAOModule();
	private MatiereService matiereService = new MatiereService();
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	
	private Singleton() {}



	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}


	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}



	public IDAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}



	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}



	public IDAOModule getDaoModule() {
		return daoModule;
	}



	public MatiereService getMatiereService() {
		return matiereService;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}

	

	
}
