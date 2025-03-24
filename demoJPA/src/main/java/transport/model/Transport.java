package transport.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
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
	
	
	@ManyToMany
	protected List<Station> stations = new ArrayList();
	
	public Transport() {}
	
	
	public Transport(LocalDate dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	


	public List<Station> getStations() {
		return stations;
	}


	public void setStations(List<Station> stations) {
		this.stations = stations;
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
