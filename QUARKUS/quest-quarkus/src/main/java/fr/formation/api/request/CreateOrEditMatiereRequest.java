package fr.formation.api.request;

import jakarta.validation.constraints.NotBlank;

public class CreateOrEditMatiereRequest {
    @NotBlank
    private String libelle;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
