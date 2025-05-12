package fr.formation.repo;

import java.util.List;

import fr.formation.model.Produit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProduitRepository implements PanacheRepository<Produit> {
    public List<Produit> findAllByFournisseurId(String fournisseurId) {
        return this.find("fournisseur.id", fournisseurId).list();
    }
}
