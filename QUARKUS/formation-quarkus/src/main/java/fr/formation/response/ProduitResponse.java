package fr.formation.response;

import java.math.BigDecimal;

public class ProduitResponse {
    private String libelle;
    private BigDecimal prix;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public ProduitResponse(String libelle, BigDecimal prix) {
        this.libelle = libelle;
        this.prix = prix;
    }
}
