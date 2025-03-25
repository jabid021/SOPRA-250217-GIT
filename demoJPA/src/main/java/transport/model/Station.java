package transport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="station")
public class Station {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //SEMI-OBLIGATOIRE
	private Integer id;
	private String nom;
	
	@ElementCollection(targetClass = Ligne.class)
	@JoinTable(name = "lignes_disponibles", joinColumns = @JoinColumn(name = "station"))
	@Column(name="ligne",nullable = false)
	@Enumerated(EnumType.STRING)
	private transient List<Ligne> lignes = new ArrayList();
	
	
	public Station() {}



	public Station(String nom) {
		this.nom = nom;
	}



	public List<Ligne> getLignes() {
		return lignes;
	}



	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Station [id=" + id + ", nom=" + nom + ", lignes=" + lignes + "]";
	}



	
	
}
