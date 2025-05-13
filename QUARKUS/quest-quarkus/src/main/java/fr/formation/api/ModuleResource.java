package fr.formation.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Views;
import fr.formation.repo.ModuleRepository;
import jakarta.annotation.security.RolesAllowed;
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

import fr.formation.model.Module;

@Path("/api/module")
public class ModuleResource {
	private final ModuleRepository repository;

	public ModuleResource(ModuleRepository repository) {
		this.repository = repository;
	}

	@GET
	@JsonView(Views.ViewModule.class)
	public List<Module> getAll() {
		return this.repository.listAll();
	}

	@Path("/{id}")
	@GET
	@JsonView(Views.ViewModule.class)
	public Module getById(@PathParam("id") Integer id) {
		return this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	@JsonView(Views.ViewModule.class)
	@RolesAllowed("admin")
	public Module create(Module module) {
		this.repository.persist(module);

		return module;
	}

	@Path("/{id}")
	@PUT
	@Transactional
	@JsonView(Views.ViewModule.class)
	@RolesAllowed({ "admin", "formateur" })
	public Response update(Module module, @PathParam("id") int id) {
		if (id != module.getId() || !this.repository.existsById(id)) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		this.repository.persist(module);

		return Response.ok(module).build();
	}

	@Path("/{id}")
	@DELETE
	@Transactional
	public Response delete(@PathParam("id") int id) {
		if (!this.repository.existsById(id)) {
			return Response.status(Status.NOT_FOUND).build();
		}

		this.repository.deleteById(id);

		return Response.ok().build();
	}
}
