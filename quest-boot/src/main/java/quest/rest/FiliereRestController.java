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

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.model.Views;

@RestController
@RequestMapping("/filiere")
public class FiliereRestController {

	private IDAOFiliere daoFiliere;

	public FiliereRestController(IDAOFiliere daoFiliere) {
		super();
		this.daoFiliere = daoFiliere;
	}

	@GetMapping("")
	@JsonView(Views.ViewFiliere.class)
	public List<Filiere> getAll() {
		return this.daoFiliere.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFiliereDetail.class)
	public Filiere getById(@PathVariable Integer id) {
		return this.daoFiliere.findByIdWithModules(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewFiliere.class)
	public Filiere create(@RequestBody Filiere filiere) {
		return this.daoFiliere.save(filiere);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFiliere.class)
	public Filiere update(@RequestBody Filiere filiere, @PathVariable Integer id) {
		if (id != filiere.getId() || !this.daoFiliere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incohérence de l'appel");
		}

		return this.daoFiliere.save(filiere);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!this.daoFiliere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non trouvé");
		}

		this.daoFiliere.deleteById(id);
	}
}
