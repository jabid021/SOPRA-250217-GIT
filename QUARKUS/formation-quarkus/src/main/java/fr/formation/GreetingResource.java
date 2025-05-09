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

    @Path("/quarkus")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        this.guitariste.jouer();

        return "Hello from Quarkus REST !!";
    }

    @GET
    public HelloResponse helloResponse() {
        return new HelloResponse("Le contenu en question");
    }

    // @Scheduled(every = "2s")
    public void demoScheduleEvery2Secs() {
        System.out.println("Toutes les 2 secondes :)");
    }
}
