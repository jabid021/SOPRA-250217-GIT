package transport.model.heritage;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Moto extends Vehicule{

	@Column(nullable = false)
	private String attributMoto;
	
	public Moto() {}

	public Moto(String marque, String attributMoto) {
		super(marque);
		this.attributMoto = attributMoto;
	}

	public String getAttributMoto() {
		return attributMoto;
	}

	public void setAttributMoto(String attributMoto) {
		this.attributMoto = attributMoto;
	}

	@Override
	public String toString() {
		return "Moto [id=" + id + ", marque=" + marque + ", attributMoto=" + attributMoto + "]";
	}
	
	
}
