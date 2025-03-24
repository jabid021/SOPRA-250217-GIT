package transport.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class Bus extends Transport{

	private int nbPlace;
	
	public Bus() {}

	public Bus(LocalDate dateFabrication, int nbPlace) {
		super(dateFabrication);
		this.nbPlace = nbPlace;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", dateFabrication=" + dateFabrication + ", nbPlace=" + nbPlace + "]";
	}

	
	
	
}
