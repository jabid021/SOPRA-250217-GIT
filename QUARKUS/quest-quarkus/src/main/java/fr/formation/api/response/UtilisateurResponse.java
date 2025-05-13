package fr.formation.api.response;

import fr.formation.model.Admin;
import fr.formation.model.Formateur;
import fr.formation.model.Stagiaire;
import fr.formation.model.Utilisateur;

public class UtilisateurResponse {
	private Integer id;
	private String identifiant;
	private UtilisateurType utilisateurType;
	// formateur ou stagiaire
	private String nom;
	private String prenom;
	private String email;
	private String genre;
	// #####################
	// stagiaire
	private String numero;
	private String voie;
	private String ville;
	private String cp;

	private Integer idFiliere;
	private Integer idOrdinateur;
	// #####################

	public UtilisateurResponse() {
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

	public UtilisateurType getUtilisateurType() {
		return utilisateurType;
	}

	public void setUtilisateurType(UtilisateurType utilisateurType) {
		this.utilisateurType = utilisateurType;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Integer getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Integer idFiliere) {
		this.idFiliere = idFiliere;
	}

	public Integer getIdOrdinateur() {
		return idOrdinateur;
	}

	public void setIdOrdinateur(Integer idOrdinateur) {
		this.idOrdinateur = idOrdinateur;
	}
	
	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse utilisateurResponse = new UtilisateurResponse();

		utilisateurResponse.setId(utilisateur.getId());

		utilisateurResponse.setIdentifiant(utilisateur.getLogin());
		
		if(utilisateur instanceof Stagiaire stagiaire) {
			utilisateurResponse.setUtilisateurType(UtilisateurType.STAGIAIRE);

			utilisateurResponse.setNom(stagiaire.getNom());
			utilisateurResponse.setPrenom(stagiaire.getPrenom());
			utilisateurResponse.setEmail(stagiaire.getEmail());
			
			if (stagiaire.getAdresse() != null) {
				utilisateurResponse.setNumero(stagiaire.getAdresse().getNumero());
				utilisateurResponse.setVoie(stagiaire.getAdresse().getVoie());
				utilisateurResponse.setVille(stagiaire.getAdresse().getVille());
				utilisateurResponse.setCp(stagiaire.getAdresse().getCp());
			}

			if (stagiaire.getGenre() != null) {
				utilisateurResponse.setGenre(stagiaire.getGenre().name());
			}

			if (stagiaire.getFiliere() != null) {
				utilisateurResponse.setIdFiliere(stagiaire.getFiliere().getId());
			}

			if (stagiaire.getOrdinateur() != null) {
				utilisateurResponse.setIdOrdinateur(stagiaire.getOrdinateur().getNumero());
			}
		}
		
		else if(utilisateur instanceof Formateur formateur) {
			utilisateurResponse.setUtilisateurType(UtilisateurType.FORMATEUR);
			
			utilisateurResponse.setNom(formateur.getNom());
			utilisateurResponse.setPrenom(formateur.getPrenom());
			
			if (formateur.getGenre() != null) {
				utilisateurResponse.setGenre(formateur.getGenre().name());
			}
		}
		
		else if (utilisateur instanceof Admin) {
			utilisateurResponse.setUtilisateurType(UtilisateurType.ADMIN);
		}
		
		return utilisateurResponse; 
	}

	public enum UtilisateurType {
		ADMIN, FORMATEUR, STAGIAIRE;
	}
}
