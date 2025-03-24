package transport.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("train")
public class Train extends Transport {

	private String couleur;
	
	public Train() {}

	public Train(LocalDate dateFabrication, String couleur) {
		super(dateFabrication);
		this.couleur = couleur;
	}


	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Train [couleur=" + couleur + "]";
	}
	
	
	
	
}
