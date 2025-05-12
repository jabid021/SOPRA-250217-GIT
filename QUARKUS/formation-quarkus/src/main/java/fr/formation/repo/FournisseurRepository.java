package fr.formation.repo;

import fr.formation.model.Fournisseur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FournisseurRepository implements PanacheRepositoryBase<Fournisseur, String> {
    
}
