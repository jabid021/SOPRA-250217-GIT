package fr.formation.musique;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Guitariste {
    @Inject
    private Guitare guitare;

    // @Inject
    // public void setGuitare(Guitare guitare) {
    //     this.guitare = guitare;
    // }
    
    public void jouer() {
        System.out.println("Le guitariste joue : " + this.guitare);
    }
}
