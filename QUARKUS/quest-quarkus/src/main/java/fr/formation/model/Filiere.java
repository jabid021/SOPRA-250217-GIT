package fr.formation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filiere")
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBasic.class)
	private Integer id;
	@Column(length = 25, nullable = false)
	@JsonView(Views.ViewBasic.class)
	private String libelle;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewBasic.class)
	private LocalDate debut;
	@Column(nullable = false) // "fin":"2025-05-08"
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewBasic.class)
	private LocalDate fin;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable ( name="module", joinColumns = @JoinColumn(name="filiere",nullable
	 * = false), inverseJoinColumns = @JoinColumn(name="matiere",nullable = false) )
	 * private List<Matiere> matieres = new ArrayList();
	 */

	@OneToMany(mappedBy = "filiere")
	@JsonView(Views.ViewFiliereDetail.class)
	private List<Module> modules = new ArrayList<>();

	@OneToMany(mappedBy = "filiere")
	private List<Stagiaire> eleves = new ArrayList<>();

	public Filiere() {
	}

	// findById/ FindAll, Update
	public Filiere(Integer id, String libelle, LocalDate debut, LocalDate fin) {
		this.id = id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}

	// Insert
	public Filiere(String libelle, LocalDate debut, LocalDate fin) {
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Stagiaire> getEleves() {
		return eleves;
	}

	public void setEleves(List<Stagiaire> eleves) {
		this.eleves = eleves;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + "]";
	}
}