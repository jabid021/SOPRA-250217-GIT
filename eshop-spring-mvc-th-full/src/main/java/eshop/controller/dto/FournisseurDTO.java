package eshop.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FournisseurDTO {
	private Integer id;
	@Pattern(regexp = "^[A-Z][A-Za-z]+$", message = "Au moins 2 caractères et 1 majuscule")
	private String nom;
	private String prenom;
	private String societe;
	@NotBlank(message = "Rue obligatoire")
	private String rue;
	@NotBlank(message = "Code postal obligatoire")
	private String codePostal;
	@NotBlank(message = "Ville obligatoire")
	private String ville;

	public FournisseurDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
