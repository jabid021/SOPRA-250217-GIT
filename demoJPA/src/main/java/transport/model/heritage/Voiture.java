package transport.model.heritage;

import javax.persistence.Entity;

@Entity
public class Voiture extends Vehicule{

	private int nbPlaces;
	
	public Voiture() {}

	public Voiture(String marque, int nbPlaces) {
		super(marque);
		this.nbPlaces = nbPlaces;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", nbPlaces=" + nbPlaces + "]";
	}
	
}
