package fr.formation.api;

import fr.formation.api.request.AuthRequest;
import fr.formation.api.response.AuthResponse;
import io.quarkus.security.credential.PasswordCredential;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.UsernamePasswordAuthenticationRequest;
import io.quarkus.security.jpa.runtime.JpaIdentityProvider;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/auth")
public class AuthResource {
    private final JpaIdentityProvider identityProvider;
    private final EntityManager entityManager;

    public AuthResource(JpaIdentityProvider identityProvider, EntityManager entityManager) {
        this.identityProvider = identityProvider;
        this.entityManager = entityManager;
    }

    @POST
    @PermitAll
    public AuthResponse auth(AuthRequest request) {
        UsernamePasswordAuthenticationRequest authenticationRequest = new UsernamePasswordAuthenticationRequest(
            request.getUsername(),
            new PasswordCredential(request.getPassword().toCharArray())
        );

        // SecurityIdentity correspondra à l'utilisateur qui vient de se connecter, si l'authentification a fonctionné
        SecurityIdentity identity = this.identityProvider.authenticate(this.entityManager, authenticationRequest);

        String jwt = Jwt.issuer("formation-quarkus-issuer")
            .upn(request.getUsername())
            .groups(identity.getRoles())
            .sign()
        ;
        
        return new AuthResponse(true, jwt);
    }
}
