package eshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	@Column(columnDefinition = "INT(3)")
	private int age;
	@Column(name = "date_naissance")
	@Past(message = "La date de naissance est invalide")
	private LocalDate dateNaissance;

	@OneToMany(mappedBy = "client")
	/*
	 * @JoinTable( name="achats", joinColumns = @JoinColumn(name="acheteur",nullable
	 * = false), inverseJoinColumns = @JoinColumn(name="produit",nullable = false) )
	 */
	private List<Achat> achats = new ArrayList<>();

	public Client() {
	}

	public Client(String nom, String prenom, int age, LocalDate naissance, Adresse adresse) {
		super(nom, prenom, adresse);
		this.age = age;
		this.dateNaissance = naissance;
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

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", dateNaissance="
				+ dateNaissance + ", adresse=" + getAdresse() + "]";
	}

}
