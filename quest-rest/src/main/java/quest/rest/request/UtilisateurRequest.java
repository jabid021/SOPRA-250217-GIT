package quest.rest.request;

public class UtilisateurRequest {
	private Integer id;
	private String identifiant;
	private String motDePasse;
	private UtilisateurType utilisateurType;

	public UtilisateurRequest() {
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

	public enum UtilisateurType {
		ADMIN, FORMATEUR, STAGIAIRE;
	}
}
