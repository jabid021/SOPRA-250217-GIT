package hopital.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Visite {

	@Id
	private Integer id;
	private Patient patient;
	private Medecin medecin;
	private double prix;
	private int salle;
	private LocalDate dateVisite;
	
	public Visite(Integer id, Patient patient, Medecin medecin, double prix, int salle, LocalDate dateVisite) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
	}

	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.prix = 20;
		this.salle = medecin.getSalle();
		this.dateVisite = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", patient=" + patient + ", medecin=" + medecin.login + ", prix=" + prix + ", salle="
				+ salle + ", dateVisite=" + dateVisite + "]";
	}
	
	
	
	
	
}
