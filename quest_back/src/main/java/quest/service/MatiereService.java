package quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {

	@Autowired
	IDAOMatiere daoMatiere;

	public Matiere getById(Integer id)
	{
		return daoMatiere.findById(id);
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
		daoMatiere.delete(id);
		return true;
	}

	public boolean delete(Matiere matiere) throws Exception 
	{
		return deleteById(matiere.getId());
	}
}
