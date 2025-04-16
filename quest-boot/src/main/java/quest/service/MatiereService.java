package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {

	@Autowired
	IDAOMatiere daoMatiere;
	
	public boolean existById(Integer id) {
		return daoMatiere.existsById(id);
	}

	public Matiere getById(Integer id)
	{
		Optional<Matiere> opt = daoMatiere.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return opt.get();}
	}

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
