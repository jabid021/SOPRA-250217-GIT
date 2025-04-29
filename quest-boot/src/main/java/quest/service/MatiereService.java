package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service("matiereServiceV1")
public class MatiereService {
	@Autowired
	IDAOMatiere daoMatiere;
	
	public boolean existById(Integer id) {
		try {
			return daoMatiere.existsById(id);
		}

		catch (RuntimeException demo) {
			return false;
		}
	}

	public Matiere getById(Integer id)
	{
		Optional<Matiere> opt = daoMatiere.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return opt.get();}
	}

	// Principe Open / Close

	// Créer une nouvelle classe MatiereServiceV2 qui intègre la modif
	// Controler -> MatiereServiceV2 -> MatiereService
	// > SAUF dans le getByLibelle qui utilisera la nouvelle version : findByLibelle Optional

	public Matiere getByLibelle(String libelle) 
	{
		try {
			return daoMatiere.findByLib(libelle);
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	public List<Matiere> getAll()
	{
		return daoMatiere.findAll();
	}

	public Matiere create(Matiere matiere) 
	{
		matiere=daoMatiere.save(matiere);
		return matiere;
	}

	public Matiere update(Matiere matiere) 
	{
		matiere=daoMatiere.save(matiere);
		return matiere;
	}

	public boolean deleteById(Integer id) 
	{
		daoMatiere.deleteById(id);
		return true;
	}

	public boolean delete(Matiere matiere) throws Exception 
	{
		return deleteById(matiere.getId());
	}
}
