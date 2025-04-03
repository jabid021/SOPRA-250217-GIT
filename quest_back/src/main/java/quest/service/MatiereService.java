package quest.service;

import java.util.List;

import quest.dao.DAOMatiere;
import quest.dao.IDAOMatiere;
import quest.model.Matiere;

public class MatiereService {

	IDAOMatiere daoMatiere = new DAOMatiere();
	
	public Matiere getById(Integer id) throws Exception 
	{
		return daoMatiere.findById(id);
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
