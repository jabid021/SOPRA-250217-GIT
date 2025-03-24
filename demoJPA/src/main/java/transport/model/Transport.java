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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//SingleTable par defaut sur Hibernate + MySQL
@Table(name="transport")
@DiscriminatorColumn(name="type_transport",columnDefinition = "ENUM('bus','train')")
public abstract class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected LocalDate dateFabrication;
	
	
	//Etant dans la classe Transport avec un lien vers Station
	//Transport est la clé principale (joinColumn), Station est secondaire (inverseJoinColumn)
	@ManyToMany
	@JoinTable(
			name="arret",
			joinColumns = @JoinColumn(name="transport",nullable=false),
			inverseJoinColumns = @JoinColumn(name="station",nullable=false),
			uniqueConstraints = @UniqueConstraint(columnNames = {"transport","station"})
			)
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
