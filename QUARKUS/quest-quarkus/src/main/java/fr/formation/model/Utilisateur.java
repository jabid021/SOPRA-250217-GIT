package fr.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur")
@Table(name = "utilisateur")
@UserDefinition
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({ 
//	@Type(value = Admin.class, name = "admin"), 
//	@Type(value = Formateur.class, name = "formateur"),
//	@Type(value = Stagiaire.class, name = "stagiaire") })
public abstract class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBasic.class)
	protected Integer id;

	@Column(length = 25, nullable = false, unique = true)
	@JsonView(Views.ViewBasic.class)
	@Username
	protected String login;
	
	@Column(length = 150, nullable = false)
	@JsonView(Views.ViewBasic.class)
	@Password(PasswordType.CLEAR)
	protected String password;

	@Column(name = "type_utilisateur", insertable = false, updatable = false)
	private String typeUtilisateur;

	public Utilisateur() {
	}

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

	@Roles
	public String getRole() {
		return this.typeUtilisateur.toLowerCase();
	}
}
