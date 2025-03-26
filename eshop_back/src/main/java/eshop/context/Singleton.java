package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOAchat;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;

public class Singleton {
	
	private static Singleton instance=null; 
	private DAOAchat daoAchat = new DAOAchat();
	private DAOProduit daoProduit = new DAOProduit();
	private DAOPersonne daoPersonne = new DAOPersonne();
	
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	
	private Singleton() {}



	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}



	public DAOAchat getDaoAchat() {
		return daoAchat;
	}



	public DAOProduit getDaoProduit() {
		return daoProduit;
	}



	public DAOPersonne getDaoPersonne() {
		return daoPersonne;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void closeEmf() 
	{
		this.emf.close();
	}


	
	

	
}
