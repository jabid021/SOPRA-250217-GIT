package fr.formation.service;

import java.util.List;

import fr.formation.model.Matiere;
import fr.formation.repo.MatiereRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatiereService {
	private final MatiereRepository repository;

	public MatiereService(MatiereRepository repository) {
		this.repository = repository;
	}

	public boolean existById(Integer id) {
		try {
			return this.repository.existsById(id);
		}

		catch (RuntimeException demo) {
			return false;
		}
	}

	public Matiere getById(Integer id) {
		return this.repository.findById(id);
	}

	public Matiere getByLibelle(String libelle) {
		try {
			return repository.findByLib(libelle);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Matiere> getAll() {
		return this.repository.listAll();
	}

	public Matiere create(Matiere matiere) {
		this.repository.persist(matiere);

		return matiere;
	}

	public Matiere update(Matiere matiere) {
		this.repository.persist(matiere);

		return matiere;
	}

	public boolean deleteById(Integer id) {
		this.repository.deleteById(id);

		return true;
	}

	public boolean delete(Matiere matiere) throws Exception {
		return this.deleteById(matiere.getId());
	}
}
