package fr.formation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;
import fr.formation.request.ProduitRequest;
import fr.formation.response.ProduitResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/produit")
public class ProduitResource {
    private static final Logger log = LoggerFactory.getLogger(ProduitResource.class);

    private final ProduitRepository repository;

    public ProduitResource(ProduitRepository repository) {
        this.repository = repository;
    }

    // @GET
    // public String findById(@QueryParam("id") int id) {
    //     return "Produit " + id;
    // }

    @GET
    public List<ProduitResponse> findAll() {
        log.debug("Liste des produits");

        return this.repository.findAll().stream()
            .map(p ->  new ProduitResponse(p.getId(), p.getLibelle(), p.getPrix()))
            .toList()
        ;
    }

    @Path("/{id}")
    @GET
    public String findByIdPath(@PathParam("id") int id) {
        return "Produit " + id;
    }

    @POST
    @Transactional
    public Response create(@Valid ProduitRequest request) {
        log.debug("Création d'un produit");

        Produit produit = new Produit();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return Response.ok(produit).build();
    }
    
    @Path("/{id}")
    @PUT
    @Transactional
    public Response edit(@PathParam("id") long id, @Valid ProduitRequest request) {
        log.debug("Modification du produit {}", id);

        Produit produit = this.repository.findById(id);

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return Response.ok(produit).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        log.debug("Suppression du produit {}", id);

        this.repository.deleteById(id);

        return Response.ok(id).build();
    }
}
