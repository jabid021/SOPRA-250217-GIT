package transport.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//SingleTable par defaut sur Hibernate + MySQL
@Table(name="transport")
@DiscriminatorColumn(name="type_transport",columnDefinition = "ENUM('bus','train')")
public abstract class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected LocalDate dateFabrication;
	
	
	public Transport() {}
	
	
	public Transport(LocalDate dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDate getDateFabrication() {
		return dateFabrication;
	}



	public void setDateFabrication(LocalDate dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	
	
	
}
