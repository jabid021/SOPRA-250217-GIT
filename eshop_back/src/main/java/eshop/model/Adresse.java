package eshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="num",length = 20)
	private String numero;
	@Column(name="street",length = 50)
	private String voie;
	@Column(name="city",length = 50)
	private String ville;
	@Column(name="pc",length = 15)
	private String cp;
	
	
	public Adresse() {}


	public Adresse(String numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + "]";
	}
	
	
}
