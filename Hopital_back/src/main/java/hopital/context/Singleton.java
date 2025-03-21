package hopital.context;

import java.io.File;
import java.util.LinkedList;

import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.dao.jdbc.DAOPatientJDBC;
import hopital.dao.jdbc.DAOVisiteJDBC;
import hopital.model.Patient;
import hopital.service.CompteService;
import hopital.service.VisiteService;

public class Singleton {
	
	private static Singleton instance=null; 
	private CompteService compteSrv = new CompteService();
	private VisiteService visiteSrv = new VisiteService();
	private IDAOPatient daoPatient = new DAOPatientJDBC();
	
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



	public CompteService getCompteSrv() {
		return compteSrv;
	}


	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}



	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}



	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}



	public VisiteService getVisiteSrv() {
		return visiteSrv;
	}



	public File getFichier() {
		return fichier;
	}



	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}



	
	

	
}
