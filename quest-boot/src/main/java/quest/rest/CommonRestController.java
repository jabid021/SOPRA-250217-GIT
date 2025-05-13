package quest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.config.jwt.JwtService;
import quest.config.jwt.JwtUtil;
import quest.dao.IDAOUtilisateur;
import quest.rest.request.ConnexionRequest;
import quest.rest.response.ConnexionResponse;

@RestController
@RequestMapping("/api")
public class CommonRestController {
	@Autowired
	private IDAOUtilisateur daoUtilisateur;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public CommonRestController() {
		super();
	}

	@PostMapping("/connexion")
	public ConnexionResponse create(@RequestBody ConnexionRequest connexionRequest) {
		// On va demander à SPRING SECURITY de vérifier le username / password
		// On a besoin d'un AuthenticationManager
		// On utilisera la méthode authenticate, qui attend un Authentication
		// Et on utilisera le type UsernamePasswordAuthenticationToken pour donner le
		// username & le password
		Authentication authentication = new UsernamePasswordAuthenticationToken(connexionRequest.getLogin(),
				connexionRequest.getPassword());

		// On demande à SPRING SECURITY de vérifier ces informations de connexion
		authentication = this.authenticationManager.authenticate(authentication);
		
		// Si on arrive ici, c'est que la connexion a fonctionné
		ConnexionResponse connexionResponse = new ConnexionResponse();

		// On génère un jeton pour l'utilisateur connecté
		// String token = JwtUtil.generate(authentication);
		String token = this.jwtService.generate(authentication);
		
		connexionResponse.setSuccess(true);
		connexionResponse.setToken(token);

		return connexionResponse;
	}
}
