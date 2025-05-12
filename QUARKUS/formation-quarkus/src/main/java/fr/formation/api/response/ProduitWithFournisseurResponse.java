package fr.formation.api.response;

import java.math.BigDecimal;

import fr.formation.model.Fournisseur;

public class ProduitWithFournisseurResponse extends ProduitResponse {
    private String fournisseurId;
    private String fournisseurNom;

    public String getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(String fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getFournisseurNom() {
        return fournisseurNom;
    }

    public void setFournisseurNom(String fournisseurNom) {
        this.fournisseurNom = fournisseurNom;
    }

    public ProduitWithFournisseurResponse(int id, String libelle, BigDecimal prix, Fournisseur fournisseur) {
        super(id, libelle, prix);

        if (fournisseur != null) {
            this.fournisseurId = fournisseur.getId();
            this.fournisseurNom = fournisseur.getNom();
        }
    }
}
