package fr.formation.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.api.request.ProduitRequest;
import fr.formation.api.response.ProduitResponse;
import fr.formation.api.response.ProduitWithFournisseurResponse;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.FournisseurRepository;
import fr.formation.repo.ProduitRepository;
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

@Path("/produit")
public class ProduitResource {
    private static final Logger log = LoggerFactory.getLogger(ProduitResource.class);

    private final ProduitRepository repository;
    private final FournisseurRepository fournisseurRepository;

    public ProduitResource(ProduitRepository repository, FournisseurRepository fournisseurRepository) {
        this.repository = repository;
        this.fournisseurRepository = fournisseurRepository;
    }

    // @GET
    // public String findById(@QueryParam("id") int id) {
    //     return "Produit " + id;
    // }

    @GET
    public List<ProduitWithFournisseurResponse> findAll() {
        log.debug("Liste des produits");

        return this.repository.findAll().stream()
            .map(p ->  new ProduitWithFournisseurResponse(p.getId(), p.getLibelle(), p.getPrix(), p.getFournisseur()))
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
        Fournisseur fournisseur = this.fournisseurRepository
            .findByIdOptional(request.getFournisseurId())
            .orElseThrow(NotFoundException::new)
        ;

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());
        produit.setFournisseur(fournisseur);

        this.repository.persist(produit);

        return Response.ok(
            new ProduitResponse(produit.getId(), produit.getLibelle(), produit.getPrix())
        ).build();
    }
    
    @Path("/{id}")
    @PUT
    @Transactional
    public Response edit(@PathParam("id") long id, @Valid ProduitRequest request) {
        log.debug("Modification du produit {}", id);

        Produit produit = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        Fournisseur fournisseur = this.fournisseurRepository
            .findByIdOptional(request.getFournisseurId())
            .orElseThrow(NotFoundException::new)
        ;

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());
        produit.setFournisseur(fournisseur);

        this.repository.persist(produit);

        return Response.ok(produit.getId()).build();
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
