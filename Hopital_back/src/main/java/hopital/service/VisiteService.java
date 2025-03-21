package hopital.service;

import java.util.List;

import hopital.dao.IDAOVisite;
import hopital.dao.jdbc.DAOVisiteJDBC;
import hopital.model.Visite;

public class VisiteService {

	IDAOVisite daoVisite = new DAOVisiteJDBC();
	
	public Visite getById(Integer id) throws Exception 
	{
		return daoVisite.findById(id);
	}
	
	public List<Visite> getAll()
	{
		return daoVisite.findAll();
	}
	
	public List<Visite> getAllByPatient(Integer id)
	{
		return daoVisite.findByPatient(id);
	}
	
	public Visite create(Visite visite) 
	{
		daoVisite.insert(visite);
		return visite;
	}
	
	public Visite update(Visite visite) 
	{
		daoVisite.update(visite);
		return visite;
	}
	
	public boolean deleteById(Integer id) 
	{
		daoVisite.delete(id);
		return true;
	}
	
	public boolean delete(Visite visite) throws Exception 
	{
		deleteById(visite.getId());
		return true;
	}
}
