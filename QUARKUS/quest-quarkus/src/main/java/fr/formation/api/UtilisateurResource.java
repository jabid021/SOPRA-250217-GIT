package fr.formation.api;

import java.util.List;

import fr.formation.api.request.InscriptionStagiaireRequest;
import fr.formation.api.request.UtilisateurRequest;
import fr.formation.api.response.UtilisateurResponse;
import fr.formation.model.Admin;
import fr.formation.model.Stagiaire;
import fr.formation.model.Utilisateur;
import fr.formation.repo.UtilisateurRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/utilisateur")
public class UtilisateurResource {
    private final UtilisateurRepository repository;

    public UtilisateurResource(UtilisateurRepository repository) {
        this.repository = repository;
    }

	@GET
	public List<UtilisateurResponse> getAll() {
		List<Utilisateur> utilisateurs = this.repository.listAll();

//		return utilisateurs.stream().map(u -> UtilisateurResponse.convert(u)).toList();
		return utilisateurs.stream().map(UtilisateurResponse::convert).toList();
	}

	@Path("/admin")
	@GET
	public List<UtilisateurResponse> getAllAdmin() {
		List<Admin> utilisateurs = this.repository.findAllAdmin();

//		return utilisateurs.stream().map(u -> UtilisateurResponse.convert(u)).toList();
		return utilisateurs.stream().map(UtilisateurResponse::convert).toList();
	}

	@Path("/{id}")
    @GET
	public UtilisateurResponse getById(@PathParam("id") Integer id) {
		return this.repository.findByIdOptional(id).map(UtilisateurResponse::convert).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	public Utilisateur create(UtilisateurRequest utilisateurRequest) {
		Utilisateur utilisateur = UtilisateurRequest.convert(utilisateurRequest);

		this.repository.persist(utilisateur);

        return utilisateur;
	}

	@Path("/{id}")
    @PUT
	@Transactional
	public Response update(UtilisateurRequest utilisateurRequest, @PathParam("id") Integer id) {
		if (id != utilisateurRequest.getId() || !this.repository.existsById(id)) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		Utilisateur utilisateur = UtilisateurRequest.convert(utilisateurRequest);

		this.repository.persist(utilisateur);

        return Response.ok(utilisateur).build();
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
	
	@Path("/inscriptionStagiaire")
    @POST
	@Transactional
	public Stagiaire create(@Valid InscriptionStagiaireRequest inscriptionStagiaireRequest) {
		Stagiaire stagiaire = InscriptionStagiaireRequest.convert(inscriptionStagiaireRequest);

		// stagiaire.setPassword(BcryptUtil.bcryptHash(stagiaire.getPassword()));

		this.repository.persist(stagiaire);

        return stagiaire;
	}
}
