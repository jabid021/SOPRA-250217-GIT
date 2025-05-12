package fr.formation.api.response;

import java.math.BigDecimal;

public class ProduitResponse {
    private int id;
    private String libelle;
    private BigDecimal prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public ProduitResponse(int id, String libelle, BigDecimal prix) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
    }
}
