package fr.formation.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.api.request.FournisseurRequest;
import fr.formation.api.response.FournisseurResponse;
import fr.formation.model.Fournisseur;
import fr.formation.repo.FournisseurRepository;
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

@Path("/fournisseur")
public class FournisseurResource {
    private static final Logger log = LoggerFactory.getLogger(FournisseurResource.class);

    private final FournisseurRepository repository;

    public FournisseurResource(FournisseurRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<FournisseurResponse> findAll() {
        log.debug("Liste des fournisseurs");

        return this.repository.findAll().stream()
            .map(f -> new FournisseurResponse(f.getId(), f.getNom()))
            .toList()
        ;
    }

    @POST
    @Transactional
    public Response create(@Valid FournisseurRequest request) {
        log.debug("Création d'un fournisseur");

        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setNom(request.getNom());

        this.repository.persist(fournisseur);

        return Response.ok(fournisseur.getId()).build();
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response edit(@PathParam("id") String id, @Valid FournisseurRequest request) {
        log.debug("Modification du fournisseur {}", id);

        Fournisseur fournisseur = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        fournisseur.setNom(request.getNom());

        this.repository.persist(fournisseur);

        return Response.ok(fournisseur.getId()).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response deleteById(@PathParam("id") String id) {
        log.debug("Suppression du fournisseur {}", id);

        try {
            this.repository.deleteById(id);

            return Response.ok(id).build();
        }

        catch (Exception e) {
            log.error("Ne peut pas supprimer le fournisseur {} : {}", id, e.getMessage());

            return Response.status(Status.BAD_REQUEST).build();
        }
    }
}
