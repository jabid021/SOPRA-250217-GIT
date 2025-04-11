package eshop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="label",length = 30,nullable = false)
	private String libelle;
	
	@Column(name="price",columnDefinition = "DECIMAL(6,2)")
	private double prix;
	
	
	@ManyToOne
	@JoinColumn(name="vendeur")
	private Fournisseur vendeur;
	
	@OneToMany(mappedBy = "produit")
	private List<Achat> ventes = new ArrayList<>();
	
	public Produit() {}

	public Produit(String libelle, double prix) {
		this.libelle = libelle;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

	public Fournisseur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Fournisseur vendeur) {
		this.vendeur = vendeur;
	}
	

	public List<Achat> getVentes() {
		return ventes;
	}

	public void setVentes(List<Achat> ventes) {
		this.ventes = ventes;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", vendeur=" + vendeur + "]";
	}

	
	
	
}
