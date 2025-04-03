package quest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ordinateur {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	private String marque;
	private int ram;
	@OneToOne
	private Stagiaire stagiaire; //mappedBy

	
	public Ordinateur() {}
	
	public Ordinateur(Integer numero, String marque, int ram) {
		this.numero = numero;
		this.marque = marque;
		this.ram = ram;
	}
	
	public Ordinateur(String marque, int ram) {
		this.marque = marque;
		this.ram = ram;
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