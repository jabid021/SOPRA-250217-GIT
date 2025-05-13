package fr.formation.api;

import java.time.Duration;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/demo-reactif")
public class DemoReactifResource {
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Long> demoStreamLong() {
        return Multi.createFrom()
            .ticks()
            .every(Duration.ofSeconds(1))
        ;
    }
}
