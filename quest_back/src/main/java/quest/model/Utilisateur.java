package quest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_utilisateur",columnDefinition = "ENUM('Admin','Formateur','Stagiaire')")
@Table(name="utilisateur")
public abstract class Utilisateur{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 25,nullable = false,unique = true)
	protected String login;
	@Column(length = 150,nullable = false)
	protected String password;
	
	public Utilisateur() {}
	
	public Utilisateur(Integer id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
