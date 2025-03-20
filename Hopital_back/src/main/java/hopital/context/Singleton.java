package hopital.context;

import java.io.File;
import java.util.LinkedList;

import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;
import hopital.model.Patient;

public class Singleton {
	
	private static Singleton instance=null; 
	private DAOCompte daoCompte = new DAOCompte();
	private DAOVisite daoVisite = new DAOVisite();
	private DAOPatient daoPatient = new DAOPatient();
	
	private LinkedList<Patient> fileAttente = new LinkedList();
	private File fichier = new File("fileAttente.txt");
	
	
	private Singleton() {}



	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}



	public DAOCompte getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}



	public DAOVisite getDaoVisite() {
		return daoVisite;
	}



	public void setDaoVisite(DAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}



	public DAOPatient getDaoPatient() {
		return daoPatient;
	}



	public void setDaoPatient(DAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}



	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}



	public File getFichier() {
		return fichier;
	}



	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}



	
	

	
}
