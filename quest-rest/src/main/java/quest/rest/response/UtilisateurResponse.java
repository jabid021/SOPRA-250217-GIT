package quest.rest.response;

public class UtilisateurResponse {
	private Integer id;
	private String identifiant;
	private String motDePasse;
	private UtilisateurType utilisateurType;
	// formateur ou stagiaire
	private String nom;
	private String prenom;
	private String genre;
	// #####################
	// stagiaire
	private String numero;
	private String voie;
	private String ville;
	private String cp;

	private Integer idFiliere;
	private Integer idOrdinateur;
	// #####################

	public UtilisateurResponse() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public UtilisateurType getUtilisateurType() {
		return utilisateurType;
	}

	public void setUtilisateurType(UtilisateurType utilisateurType) {
		this.utilisateurType = utilisateurType;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Integer getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Integer idFiliere) {
		this.idFiliere = idFiliere;
	}

	public Integer getIdOrdinateur() {
		return idOrdinateur;
	}

	public void setIdOrdinateur(Integer idOrdinateur) {
		this.idOrdinateur = idOrdinateur;
	}

	public enum UtilisateurType {
		ADMIN, FORMATEUR, STAGIAIRE;
	}
}
