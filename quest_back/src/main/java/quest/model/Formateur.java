package quest.model;

public class Formateur extends Utilisateur {
	private String nom;
	private String prenom;
	private Genre genre;
	
	public Formateur(Integer id, String login, String password, String nom, String prenom, Genre genre) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}
	
	public Formateur(String login, String password, String nom, String prenom, Genre genre) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", genre=" + genre + "]";
	}
	


	
}