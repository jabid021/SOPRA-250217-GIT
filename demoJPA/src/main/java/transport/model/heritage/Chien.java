package transport.model.heritage;

import javax.persistence.Entity;

@Entity
public class Chien extends Animal {

	private String attributChien;
	public Chien() {}
	
	
	public Chien(String couleur, String attributChien) {
		super(couleur);
		this.attributChien = attributChien;	
	}


	public String getAttributChien() {
		return attributChien;
	}
	public void setAttributChien(String attributChien) {
		this.attributChien = attributChien;
	}


	@Override
	public String toString() {
		return "Chien [id=" + id + ", couleur=" + couleur + ", attributChien=" + attributChien + "]";
	}
	
	
}
