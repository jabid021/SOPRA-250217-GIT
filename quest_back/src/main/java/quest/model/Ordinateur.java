package quest.model;

public class Ordinateur {

	private Integer numero;
	private String marque;
	private int ram;
	private Stagiaire stagiaire; //mappedBy

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