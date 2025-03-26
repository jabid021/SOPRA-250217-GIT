package transport.model.heritage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="table_lion")
@PrimaryKeyJoinColumn(name="id_lion")
public class Lion extends Animal{
	


	@Column(name="attribut_lion",nullable = false,length = 30)
	private String attributLion;
	
	public Lion() {}

	public Lion(String couleur, String attributLion) {
		super(couleur);
		this.attributLion = attributLion;
	}

	public String getAttributLion() {
		return attributLion;
	}

	public void setAttributLion(String attributLion) {
		this.attributLion = attributLion;
	}

	@Override
	public String toString() {
		return "Lion [id=" + id + ", couleur=" + couleur + ", attributLion=" + attributLion + "]";
	}
	
	
}

