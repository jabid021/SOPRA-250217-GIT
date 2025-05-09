package fr.formation;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.request.ProduitRequest;
import fr.formation.response.ProduitResponse;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/produit")
public class ProduitResource {
    // @GET
    // public String findById(@QueryParam("id") int id) {
    //     return "Produit " + id;
    // }

    @GET
    public List<ProduitResponse> findAll() {
        System.out.println("Liste des produits");

        return List.of(
            new ProduitResponse("Parachute de France", new BigDecimal("6999")),
            new ProduitResponse("Casque", new BigDecimal("499.5"))
        );
    }

    @Path("/{id}")
    @GET
    public String findByIdPath(@PathParam("id") int id) {
        return "Produit " + id;
    }

    @POST
    public Response create(ProduitRequest request) {
        System.out.println("Création d'un produit");

        System.out.println("Libellé = " + request.getLibelle());
        System.out.println("Prix = " + request.getPrix());

        return Response.ok().build();
    }

    
    @Path("/{id}")
    @PUT
    public Response edit(@PathParam("id") int id, ProduitRequest request) {
        System.out.println("Modification du produit " + id);

        System.out.println("Libellé = " + request.getLibelle());
        System.out.println("Prix = " + request.getPrix());

        return Response.ok().build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteById(@PathParam("id") int id) {
        System.out.println("Suppression du produit " + id);

        return Response.ok().build();
    }
}
