package transport.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="billet")
public class Billet {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //SEMI-OBLIGATOIRE
	private Integer id;
	@Column(name="date_trajet")
	private LocalDate dateTrajet;
	
	//en bdd, le type DECIMAL permet de limiter le nombre digit
	//x => nombre digit total
	//y => digits apres la virgule
	@Column(columnDefinition = "DECIMAL(5,2)")
	private double prix;
	private boolean valide;
	
	

	
	public Billet() {}
		
	public Billet(LocalDate dateTrajet, double prix, boolean valide) {
		this.dateTrajet = dateTrajet;
		this.prix = prix;
		this.valide = valide;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateTrajet() {
		return dateTrajet;
	}


	public void setDateTrajet(LocalDate dateTrajet) {
		this.dateTrajet = dateTrajet;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public boolean isValide() {
		return valide;
	}


	public void setValide(boolean valide) {
		this.valide = valide;
	}


	@Override
	public String toString() {
		return "Billet [id=" + id + ", dateTrajet=" + dateTrajet + ", prix=" + prix + ", valide=" + valide + "]";
	}
	
	
	
	

	
	
	
}
