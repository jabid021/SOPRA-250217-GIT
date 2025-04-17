package quest.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOUtilisateur;
import quest.model.Utilisateur;
import quest.rest.request.ConnexionRequest;
import quest.rest.response.ConnexionResponse;

@RestController
@RequestMapping("/api")
public class CommonRestController {

	private IDAOUtilisateur daoUtilisateur;

	public CommonRestController(IDAOUtilisateur daoUtilisateur) {
		super();
		this.daoUtilisateur = daoUtilisateur;
	}

	@PostMapping("/connexion")
	public ConnexionResponse create(@RequestBody ConnexionRequest connexionRequest) {
		Utilisateur utilisateur = daoUtilisateur.findByLoginAndPassword(connexionRequest.getLogin(), connexionRequest.getPassword());

		ConnexionResponse connexionResponse = new ConnexionResponse();
		
		if(utilisateur != null) {
			connexionResponse.setSuccess(true);
		} else {
			connexionResponse.setSuccess(false);
		}
		
		return connexionResponse;
	}
}
