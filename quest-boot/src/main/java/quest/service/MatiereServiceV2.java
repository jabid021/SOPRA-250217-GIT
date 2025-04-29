package quest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service("matiereService")
public class MatiereServiceV2 extends MatiereService {
    private final MatiereService instanceV1;
	private final IDAOMatiere daoMatiere;

    public MatiereServiceV2(MatiereService matiereServiceV1, IDAOMatiere daoMatiere) {
        this.instanceV1 = matiereServiceV1;
        this.daoMatiere = daoMatiere;
    }
	
	public boolean existById(Integer id) {
		return this.instanceV1.existById(id);
	}

	public Matiere getById(Integer id) {
		return this.instanceV1.getById(id);
	}

	// Principe Open / Close

	public Matiere getByLibelle(String libelle) {
        // return this.daoMatiere.findByLibelle(libelle).orElse(null);
        return this.daoMatiere.findByLibelle(libelle).orElseThrow(() -> new RuntimeException());
	}

	public List<Matiere> getAll() {
        return this.instanceV1.getAll();
	}

	public Matiere create(Matiere matiere) {
        return this.instanceV1.create(matiere);
	}

	public Matiere update(Matiere matiere) {
        return this.instanceV1.update(matiere);
	}

	public boolean deleteById(Integer id) {
        return this.instanceV1.deleteById(id);
	}

	public boolean delete(Matiere matiere) throws Exception {
        return this.instanceV1.delete(matiere);
	}
}
