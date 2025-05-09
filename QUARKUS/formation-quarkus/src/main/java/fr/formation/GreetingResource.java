package fr.formation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    private final Guitariste guitariste;

    public GreetingResource(Guitariste guitariste) {
        this.guitariste = guitariste;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        this.guitariste.jouer();

        return "Hello from Quarkus REST !!";
    }
}
