package fr.formation.api;

import java.util.List;

import fr.formation.api.request.CreateOrEditMatiereRequest;
import fr.formation.api.response.MatiereResponse;
import fr.formation.model.Matiere;
import fr.formation.service.MatiereService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/matiere")
public class MatiereResource {
	private final MatiereService service;

	public MatiereResource(MatiereService service) {
		this.service = service;
	}

	@GET
	public List<MatiereResponse> getAll() {
		return this.service.getAll().stream()
			.map(m -> new MatiereResponse(m.getId(), m.getLibelle()))
			.toList()
		;
	}

	@Path("/{id}")
	@GET
	public MatiereResponse getById(@PathParam("id") Integer id) {
		Matiere matiere = this.service.getById(id);

		return new MatiereResponse(matiere.getId(), matiere.getLibelle());
	}

	@Path("/by-libelle/{libelle}")
	@GET
	public MatiereResponse getByLibelle(@PathParam("libelle") String libelle) {
		Matiere matiere = this.service.getByLibelle(libelle);

		return new MatiereResponse(matiere.getId(), matiere.getLibelle());
	}

	@POST
	@Transactional
	@RolesAllowed("admin")
	public Response create(@Valid CreateOrEditMatiereRequest request) {
		Matiere matiere = new Matiere();

		matiere.setLibelle(request.getLibelle());

		this.service.create(matiere);

		return Response.ok(matiere.getId()).build();
	}

	@Path("/{id}")
	@PUT
	@Transactional
	public Response update(@Valid CreateOrEditMatiereRequest request, @PathParam("id") Integer id) {
		Matiere matiere = this.service.getById(id);

		if (matiere == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		matiere.setLibelle(request.getLibelle());

		this.service.update(matiere);

		return Response.ok(matiere).build();
	}

	@Path("/{id}")
	@DELETE
	@Transactional
	public Response delete(@PathParam("id") Integer id) {
		if (!this.service.existById(id)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		this.service.deleteById(id);

		return Response.ok(id).build();
	}
}
