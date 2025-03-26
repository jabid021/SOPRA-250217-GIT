package transport.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import transport.dao.DAOArret;
import transport.dao.DAOBillet;
import transport.dao.DAOCompagnie;
import transport.dao.DAOPassager;
import transport.dao.DAOStation;
import transport.dao.DAOTransport;

public class Singleton {
	
	private static Singleton instance=null; 
	private DAOArret daoArret = new DAOArret();
	private DAOBillet daoBillet = new DAOBillet();
	private DAOPassager daoPassager = new DAOPassager();
	private DAOStation daoStation = new DAOStation();
	private DAOTransport daoTransport = new DAOTransport();
	private DAOCompagnie daoCompagnie = new DAOCompagnie();
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	
	private Singleton() {}



	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}



	public DAOArret getDaoArret() {
		return daoArret;
	}



	public DAOBillet getDaoBillet() {
		return daoBillet;
	}



	public DAOPassager getDaoPassager() {
		return daoPassager;
	}



	public DAOStation getDaoStation() {
		return daoStation;
	}



	public DAOTransport getDaoTransport() {
		return daoTransport;
	}



	public DAOCompagnie getDaoCompagnie() {
		return daoCompagnie;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}


	
	

	
}
