package fr.formation.api;

import fr.formation.api.request.SubscribeRequest;
import fr.formation.model.Utilisateur;
import fr.formation.repo.UtilisateurRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/utilisateur")
public class UtilisateurResource {
    private final UtilisateurRepository repository;

    public UtilisateurResource(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Path("/inscription")
    @POST
    @Transactional
    public Response subscribe(SubscribeRequest request) {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setUsername(request.getUsername());
        utilisateur.setPassword(BcryptUtil.bcryptHash(request.getPassword()));

        if ("admin".equals(request.getUsername())) {
            utilisateur.setRole("admin");
        }

        else {
            utilisateur.setRole("user");
        }

        this.repository.persist(utilisateur);

        return Response.ok(utilisateur.getId()).build();
    }
}
