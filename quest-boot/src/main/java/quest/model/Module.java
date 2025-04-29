package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewFiliere.class)
	private Integer id;

	// @Column(columnDefinition = "INTEGER(4)")
	@JsonView(Views.ViewBasic.class)
	private int quest;
	
	// @Column(columnDefinition = "int(2)")
	@JsonView(Views.ViewBasic.class)
	private int duree;

	@ManyToOne
	@JoinColumn(name = "filiere", nullable = false)
	@JsonView(Views.ViewModule.class)
	private Filiere filiere;
	@ManyToOne
	@JoinColumn(name = "matiere", nullable = false)
	@JsonView(Views.ViewModule.class)
	private Matiere matiere;

	public Module() {
	}

	public Module(Integer id, int quest, int duree, Filiere filiere, Matiere matiere) {
		this.id = id;
		this.quest = quest;
		this.duree = duree;
		this.filiere = filiere;
		this.matiere = matiere;
	}

	public Module(int quest, int duree, Filiere filiere, Matiere matiere) {
		this.quest = quest;
		this.duree = duree;
		this.filiere = filiere;
		this.matiere = matiere;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuest() {
		return quest;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", quest=" + quest + ", duree=" + duree + ", filiere=" + filiere + ", matiere="
				+ matiere + "]";
	}

}
