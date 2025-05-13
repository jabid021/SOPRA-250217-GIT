package fr.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBasic.class)
	private Integer numero;
	@JsonView(Views.ViewBasic.class)
	private String marque;
	@JsonView(Views.ViewBasic.class)
	private int ram;
	@OneToOne
	@JoinColumn(name = "stagiaire", nullable = false)
	@JsonView(Views.ViewOrdinateurDetail.class)
	private Stagiaire stagiaire;

	public Ordinateur() {
	}

	public Ordinateur(Integer numero, String marque, int ram, Stagiaire stagiaire) {
		this.numero = numero;
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}

	public Ordinateur(String marque, int ram, Stagiaire stagiaire) {
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public String toString() {
		return "Ordinateur [numero=" + numero + ", marque=" + marque + ", ram=" + ram + "]";
	}
}