package fr.formation.repo;

import java.util.Optional;

import fr.formation.model.Matiere;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatiereRepository implements QuestRepositoryBase<Matiere> {
	public Matiere findByLib(String libelle) {
		return this.find("select m from Matiere m where m.libelle = ?1", libelle).firstResult();
	}

	public Optional<Matiere> findByLibelle(String libelle) {
		return this.find("libelle", libelle).firstResultOptional();
	}
}
