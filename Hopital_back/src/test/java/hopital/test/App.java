package hopital.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.dao.IDAOPatient;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;
import hopital.service.CompteService;
import hopital.service.VisiteService;

public class App {

	static CompteService compteSrv = Singleton.getInstance().getCompteSrv();
	static IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
	static VisiteService visiteSrv = Singleton.getInstance().getVisiteSrv();
	static Compte connected = null;
	static boolean isPause = false;

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}




	public static void menuPrincipal() {
		System.out.println("\n-----------Menu principal-----------");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Stop");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}
		menuPrincipal();

	}


	public static void seConnecter() {
		String login =saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		connected = compteSrv.getByLoginAndPassword(login, password);
		if(connected == null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Saisir la salle");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else 
		{
			if(isPause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}
	}



	public static void menuSecretaire() {
		System.out.println("\n------Menu Secretaire--------");
		System.out.println("1 - Ajouter un patientà la file d'attente");
		System.out.println("2 - Voir les anciennes visites d'un patient");
		System.out.println("3 - Afficher l'etat de la file d'attente");
		System.out.println("4 - Partir en pause");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : ajouterPatient();break;
		case 2 : anciennesVisites();break;
		case 3 : afficherFileAttente(); break;
		case 4 : partirPause();break;
		case 5 : seDeconnecter();menuPrincipal();break;
		}
		menuSecretaire();
	}



	public static void seDeconnecter() {
		connected=null;
	}

	public static void partirPause() {
		try {
			FileOutputStream fos = new FileOutputStream(Singleton.getInstance().getFichier());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(Singleton.getInstance().getFileAttente());
			Singleton.getInstance().getFileAttente().clear();
			isPause=true;

			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuSecretairePause();
	}

	public static void revenirPause() {
		try {
			FileInputStream fis = new FileInputStream(Singleton.getInstance().getFichier());
			ObjectInputStream ois = new ObjectInputStream(fis);

			Singleton.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
			isPause=false;

			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		menuSecretaire();
	}

	public static void afficherFileAttente() {
		LinkedList<Patient> fileAttente = Singleton.getInstance().getFileAttente();
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			for(Patient p : fileAttente) {System.out.println(p);}
			if(connected instanceof Medecin) 
			{
				System.out.println("Le prochain patient sera : "+fileAttente.peekFirst());
			}
		}
	}

	public static void anciennesVisites() {
		Integer idPatient = saisieInt("Saisir l'id du patient");
		List<Visite> visites = visiteSrv.getAllByPatient(idPatient);
		if(visites.isEmpty()) {System.out.println("Pas de visite pour ce patient");}
		for(Visite v : visites) 
		{
			System.out.println(v);
		}

	}

	public static void ajouterPatient() {
		Integer id = saisieInt("Saisir votre id");
		Patient patient = daoPatient.findById(id);
		
		if(patient==null) 
		{
			System.out.println("Nouveau patient dans l'hopital :");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			patient = new Patient(id,nom,prenom);
			daoPatient.insert(patient);
		}
		System.out.println("Patient ajouté à la file d'attente : "+patient);
		Singleton.getInstance().getFileAttente().add(patient);

	}

	public static void menuSecretairePause() {
		System.out.println("\n------Menu Secretaire PAUSE--------");
		System.out.println("1 - Revenir de pause");
		System.out.println("2 - Se deconnecter");
		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : revenirPause();break;
		case 2 : seDeconnecter();menuPrincipal();break;
		}
		menuSecretairePause();

	}



	public static void menuMedecin() {
		System.out.println("\n------Menu Medecin--------");
		System.out.println("1 - Recevoir patient");
		System.out.println("2 - Voir l'etat de la file d'attente");
		System.out.println("3 - Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir menu");
		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFileAttente();break;
		case 3 : saveVisites();break;
		case 4 : saveVisites();seDeconnecter();menuPrincipal();break;
		}
		menuMedecin();
	}

	public static void saveVisites() {
		Medecin medecin = (Medecin) connected;
		
		if(medecin.getConsultations().isEmpty()) 
		{
			System.out.println("Aucune visite à sauvegarder");
		}
		for(Visite v : medecin.getConsultations()) 
		{
			visiteSrv.create(v);
			System.out.println("Sauvegarde en bdd de la visite : "+v);
		}
		medecin.getConsultations().clear();
	}

	public static void recevoirPatient() {
		LinkedList<Patient> fileAttente = Singleton.getInstance().getFileAttente();
		Medecin medecin = (Medecin) connected;
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Patient patient = fileAttente.poll();
			System.out.println("Creation d'une visite pour le patient : "+patient);
			Visite v = new Visite(patient,medecin);
			medecin.getConsultations().add(v);
			if(medecin.getConsultations().size()>=3)
			{
				System.out.println("Vous avez atteint 3 visites, save auto :");
				saveVisites();
			}
		}
	}

	public static void main(String[] args) {
		menuPrincipal();
	}
}
