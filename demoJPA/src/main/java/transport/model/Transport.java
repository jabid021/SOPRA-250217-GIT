package transport.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
	
	
	//Etant dans la classe Transport avec un lien vers Station
	//Transport est la clé principale (joinColumn), Station est secondaire (inverseJoinColumn)
	@OneToMany(mappedBy="transport")
	/*@JoinTable(
			name="old_table_arret",
			joinColumns = @JoinColumn(name="transport",nullable=false),
			inverseJoinColumns = @JoinColumn(name="station",nullable=false),
			uniqueConstraints = @UniqueConstraint(columnNames = {"transport","station"})
			)*/
	protected List<Arret> arrets = new ArrayList();
	
	@OneToMany(mappedBy = "transport")
	protected List<Billet> billets;
	
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


	public List<Arret> getArrets() {
		return arrets;
	}


	public void setArrets(List<Arret> arrets) {
		this.arrets = arrets;
	}


	public List<Billet> getBillets() {
		return billets;
	}


	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}
	
	
	
}
