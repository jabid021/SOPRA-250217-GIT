package transport.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity //Obligatoire
@Table(name="traveler",uniqueConstraints = @UniqueConstraint(columnNames = { "lastname","firstname" }))
public class Passager  {

	@Id //Obligatoire
	@GeneratedValue(strategy =GenerationType.IDENTITY) //SEMI-OBLIGATOIRE
	private Integer id;
	@Column(name="firstname",nullable = false,length = 50)
	private String prenom;
	
	@Column(name="lastname",columnDefinition = "VARCHAR(35)")
	private String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genre",columnDefinition = "ENUM('homme','femme','nb')", nullable = false)
	private Civilite civilite;
	
	
	@Embedded
	private Adresse adresse;
	
	
	public Passager() {} //Obligatoire
	
	
	public Passager(String prenom, String nom, Civilite civilite) {
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;	
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Civilite getCivilite() {
		return civilite;
	}


	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Passager [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", adresse="
				+ adresse + "]";
	}



	
	
	
}
