package fr.formation.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Ordinateur;
import fr.formation.model.Views;
import fr.formation.repo.OrdinateurRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/ordinateur")
public class OrdinateurResource {
	private final OrdinateurRepository repository;

	public OrdinateurResource(OrdinateurRepository repository) {
		this.repository = repository;
	}

	@GET
	@JsonView(Views.ViewOrdinateur.class)
	public List<Ordinateur> getAll() {
		return this.repository.listAll();
	}

	@Path("/{id}")
	@GET
	@JsonView(Views.ViewOrdinateur.class)
	public Ordinateur getById(@PathParam("id") Integer id) {
		return this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}
	
	@Path("/{id}/detail")
	@GET
	@JsonView(Views.ViewOrdinateurDetail.class)
	public Ordinateur getDetailById(@PathParam("id") Integer id) {
		return this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	@JsonView(Views.ViewOrdinateurDetail.class)
	public Ordinateur create(Ordinateur ordinateur) {
		this.repository.persist(ordinateur);

		return ordinateur;
	}

	@Path("/{id}")
	@PUT
	@Transactional
	@JsonView(Views.ViewOrdinateur.class)
	public Response update(Ordinateur ordinateur, @PathParam("id") Integer id) {
		if (id != ordinateur.getNumero() || !this.repository.existsById(id)) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		this.repository.persist(ordinateur);

		return Response.ok(ordinateur).build();
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
