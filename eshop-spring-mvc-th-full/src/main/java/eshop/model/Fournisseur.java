package eshop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name = "company", length = 30)
	private String societe;

	@OneToMany(mappedBy = "vendeur")
	private List<Produit> stock = new ArrayList<>();

	public Fournisseur() {
	}

	public Fournisseur(String nom, String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}

	public Fournisseur(String nom, String prenom, String societe, Adresse adresse) {
		super(nom, prenom, adresse);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", societe=" + societe + "]";
	}

}
