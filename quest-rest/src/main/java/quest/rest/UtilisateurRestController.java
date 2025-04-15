package quest.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import quest.dao.IDAOUtilisateur;
import quest.model.Utilisateur;
import quest.rest.request.UtilisateurRequest;
import quest.rest.response.UtilisateurResponse;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurRestController {

	private IDAOUtilisateur daoUtilisateur;

	public UtilisateurRestController(IDAOUtilisateur daoUtilisateur) {
		super();
		this.daoUtilisateur = daoUtilisateur;
	}

	@GetMapping("")
	public List<UtilisateurResponse> getAll() {
//		return this.daoUtilisateur.findAll();
		return null;
	}

	@GetMapping("/{id}")
	public UtilisateurResponse getById(@PathVariable Integer id) {
//		return this.daoUtilisateur.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return null;
	}

	@PostMapping("")
	public Utilisateur create(@RequestBody UtilisateurRequest utilisateurRequest) {

		return null;
	}

	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody UtilisateurRequest utilisateurRequest, @PathVariable Integer id) {
//		if (id != utilisateur.getId() || !this.daoUtilisateur.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incohérence de l'appel");
//		}

		return null;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!this.daoUtilisateur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non trouvé");
		}

		this.daoUtilisateur.deleteById(id);
	}
}
