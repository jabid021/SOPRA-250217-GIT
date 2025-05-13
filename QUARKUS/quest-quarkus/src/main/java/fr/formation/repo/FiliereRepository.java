package fr.formation.repo;

import java.util.List;

import fr.formation.model.Filiere;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FiliereRepository implements QuestRepositoryBase<Filiere> {
	public List<Filiere> findAllWithModules() {
		return this.find("select distinct f from Filiere f left join fetch f.modules").list();
	}
	
	public Filiere findByIdWithModules(Integer idFiliere) {
		return this.find("select distinct f from Filiere f left join fetch f.modules where f.id = ?1", idFiliere).firstResult();
	}
	
	public Filiere findByIdWithStagiaires(Integer idFiliere) {
		return this.find("select distinct f from Filiere f left join fetch f.eleves where f.id = ?1", idFiliere).firstResult();
	}
}
