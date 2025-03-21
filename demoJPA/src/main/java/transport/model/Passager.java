package transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Obligatoire
public class Passager  {

	@Id //Obligatoire
	@GeneratedValue(strategy =GenerationType.IDENTITY) //SEMI-OBLIGATOIRE
	private Integer id;
	private String prenom;
	private String nom;
	private Civilite civilite;
	
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


	@Override
	public String toString() {
		return "Passager [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + "]";
	}
	
	
	
	
}
