package transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="compagnie")
@SequenceGenerator(name = "seqCompagnie",sequenceName = "seqCompagnieBDD")
public class Compagnie {
 
	
	//3 type d'id auto increment :
	//1) Identity (auto increment de mysql)
	//2) Table => Toutes les classes qui sont en .Table vont aller piocher dans la même table (hibernate_sequences) leur prochain id, impossible d'avoir un billet id 1 et un passager id 1 
	//3) Sequence sans generator =>  Toutes les classes qui sont en .Sequence vont aller piocher dans la même table ((hibernate_sequence) leur prochain id, impossible d'avoir un billet id 1 et un passager id 1 
	//3) Sequence avec generator => @SequenceGenerator va creer une table dédié pour gerer l'id auto increment de notre Compagnie, cette sequence peut etre de nouveau use dans d'autre classe si besoin mais autant faire du .Table ou .Sequence sans generator !
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seqCompagnie")
	private Integer id;
	private String nom;
	
	public Compagnie() {}

	
	public Compagnie(String nom) {
		this.nom = nom;
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
	
	

}
