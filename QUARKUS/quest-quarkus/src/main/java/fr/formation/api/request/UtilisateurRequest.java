package fr.formation.api.request;

import fr.formation.model.Admin;
import fr.formation.model.Formateur;
import fr.formation.model.Stagiaire;
import fr.formation.model.Utilisateur;

public class UtilisateurRequest {
	private Integer id;
	private String identifiant;
	private String motDePasse;
	private UtilisateurType utilisateurType;

	public UtilisateurRequest() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public UtilisateurType getUtilisateurType() {
		return utilisateurType;
	}

	public void setUtilisateurType(UtilisateurType utilisateurType) {
		this.utilisateurType = utilisateurType;
	}

	public static Utilisateur convert(UtilisateurRequest utilisateurRequest) {
		Utilisateur utilisateur = null;

		if (utilisateurRequest.getUtilisateurType() == UtilisateurType.ADMIN) {
			utilisateur = new Admin();
		}
		
		else if(utilisateurRequest.getUtilisateurType() == UtilisateurType.FORMATEUR) {
			utilisateur = new Formateur();
		}
		
		else if(utilisateurRequest.getUtilisateurType() == UtilisateurType.STAGIAIRE) {
			utilisateur = new Stagiaire();
		}
		
		utilisateur.setId(utilisateurRequest.getId());
		utilisateur.setLogin(utilisateurRequest.getIdentifiant());
		utilisateur.setPassword(utilisateurRequest.getMotDePasse());
		
		return utilisateur;
	}
	
	public enum UtilisateurType {
		ADMIN, FORMATEUR, STAGIAIRE;
	}
}
