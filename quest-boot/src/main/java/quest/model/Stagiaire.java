package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Stagiaire extends Utilisateur {

	@Column(length = 25)
	@JsonView(Views.ViewBasic.class)
	private String nom;
	@Column(length = 25)
	@JsonView(Views.ViewBasic.class)
	private String prenom;

	@Enumerated(EnumType.STRING)
	// @Column(columnDefinition = "ENUM('homme','femme','nb')")
	@JsonView(Views.ViewBasic.class)
	private Genre genre;

	@Column(length = 30)
	@JsonView(Views.ViewBasic.class)
	private String email;
	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "filiere")
	private Filiere filiere;

	@OneToOne(mappedBy = "stagiaire")
	private Ordinateur ordinateur;

	public Stagiaire() {
	}

	public Stagiaire(Integer id, String login, String password, String nom, String prenom, Genre genre, String email,
			String numero, String voie, String ville, String cp, Filiere filiere) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.email = email;
		this.adresse = new Adresse(numero, voie, ville, cp);
		this.filiere = filiere;
	}

	public Stagiaire(String login, String password, String nom, String prenom, Genre genre, String email, String numero,
			String voie, String ville, String cp, Filiere filiere) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.email = email;
		this.adresse = new Adresse(numero, voie, ville, cp);
		this.filiere = filiere;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", genre=" + genre + ", email=" + email + ", adresse=" + adresse + ", filiere=" + filiere
				+ ", ordinateur=" + ordinateur + "]";
	}

}
