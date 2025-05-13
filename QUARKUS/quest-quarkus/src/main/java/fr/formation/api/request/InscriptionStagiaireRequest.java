package fr.formation.api.request;

import fr.formation.model.Adresse;
import fr.formation.model.Filiere;
import fr.formation.model.Genre;
import fr.formation.model.Ordinateur;
import fr.formation.model.Stagiaire;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InscriptionStagiaireRequest {
	@NotBlank
	private String identifiant;

	@Size(min = 5)
	private String motDePasse;

	@NotBlank
	private String nom;

	@NotBlank
	private String prenom;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String genre;
	
	private String numero;
	private String voie;
	private String ville;
	private String cp;

	private Integer idFiliere;
	private Integer idOrdinateur;

	public InscriptionStagiaireRequest() {
		super();
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

	public static Stagiaire convert(InscriptionStagiaireRequest inscriptionStagiaireRequest) {
		Stagiaire stagiaire = new Stagiaire();
		Adresse adresse = new Adresse();

		stagiaire.setNom(inscriptionStagiaireRequest.getNom());
		stagiaire.setPrenom(inscriptionStagiaireRequest.getPrenom());
		stagiaire.setEmail(inscriptionStagiaireRequest.getEmail());
		stagiaire.setGenre(Genre.valueOf(inscriptionStagiaireRequest.getGenre()));

		adresse.setNumero(inscriptionStagiaireRequest.getNumero());
		adresse.setVoie(inscriptionStagiaireRequest.getVoie());
		adresse.setVille(inscriptionStagiaireRequest.getVille());
		adresse.setCp(inscriptionStagiaireRequest.getCp());

		stagiaire.setAdresse(adresse);
		stagiaire.setLogin(inscriptionStagiaireRequest.getIdentifiant());
		stagiaire.setPassword(inscriptionStagiaireRequest.getMotDePasse());

		if (inscriptionStagiaireRequest.getIdFiliere() != null) {
			Filiere filiere = new Filiere();
			filiere.setId(inscriptionStagiaireRequest.getIdFiliere());
			stagiaire.setFiliere(filiere);
		}

		if (inscriptionStagiaireRequest.getIdOrdinateur() != null) {
			Ordinateur ordinateur = new Ordinateur();
			ordinateur.setNumero(inscriptionStagiaireRequest.getIdOrdinateur());
			stagiaire.setOrdinateur(ordinateur);
		}

		return stagiaire;
	}

	public enum UtilisateurType {
		ADMIN, FORMATEUR, STAGIAIRE;
	}
}
