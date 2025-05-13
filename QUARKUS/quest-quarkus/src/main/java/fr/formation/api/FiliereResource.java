package fr.formation.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Filiere;
import fr.formation.model.Views;
import fr.formation.repo.FiliereRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/filiere")
public class FiliereResource {
	private final FiliereRepository repository;

	public FiliereResource(FiliereRepository repository) {
		this.repository = repository;
	}

	@GET
	@JsonView(Views.ViewFiliere.class)
	public List<Filiere> getAll() {
		return this.repository.listAll();
	}

	@Path("/{id}")
	@GET
	@JsonView(Views.ViewFiliereDetail.class)
	public Filiere getById(@PathParam("id") Integer id) {
		return this.repository.findByIdWithModules(id);
	}

	@POST
	@Transactional
	@JsonView(Views.ViewFiliere.class)
	@RolesAllowed("admin")
	public Filiere create(Filiere filiere) {
		this.repository.persist(filiere);

		return filiere;
	}

	@Path("/{id}")
	@PUT
	@Transactional
	@JsonView(Views.ViewFiliere.class)
	@RolesAllowed({ "admin", "formateur" })
	public Response update(Filiere filiere, @PathParam("id") Integer id) {
		if (id != filiere.getId() || !this.repository.existsById(id)) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		this.repository.persist(filiere);

		return Response.ok(filiere).build();
	}

	@Path("/{id}")
	@DELETE
	@Transactional
	public Response delete(@PathParam("id") Integer id) {
		if (!this.repository.existsById(id)) {
			return Response.status(Status.NOT_FOUND).build();

		}

		this.repository.deleteById(id);

		return Response.ok().build();
	}
}
