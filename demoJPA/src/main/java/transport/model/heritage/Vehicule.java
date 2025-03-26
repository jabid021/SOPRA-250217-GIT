package transport.model.heritage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqV",sequenceName = "seq_vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seqV")
	@Column(name="id_vehicule")
	protected Integer id;
	
	protected String marque;
	
	
	public Vehicule() {}


	public Vehicule(String marque) {
		this.marque = marque;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
}
