package eshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	@Column(columnDefinition = "INT(3)")
	private int age;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	public Client() {}

	public Client(String nom, String prenom, int age, LocalDate naissance, Adresse adresse) {
		super(nom, prenom);
		this.age = age;
		this.dateNaissance = naissance;
		this.adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate naissance) {
		this.dateNaissance = naissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", naissance=" + dateNaissance
				+ ", adresse=" + adresse + "]";
	}
	
	
	
}
