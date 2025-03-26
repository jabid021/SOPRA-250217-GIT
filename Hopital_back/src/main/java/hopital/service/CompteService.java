package hopital.service;

import java.util.List;

import hopital.dao.IDAOCompte;
import hopital.dao.jpa.DAOCompte;
import hopital.model.Compte;

public class CompteService {

	IDAOCompte daoCompte = new DAOCompte();
	
	public Compte getById(Integer id) throws Exception 
	{
		if(id==null) 
		{
			throw new Exception("Impossible de chercher un compte sans id ?!");
		}
		return daoCompte.findById(id);
	}
	
	public Compte getByLoginAndPassword(String login,String password) 
	{
		return daoCompte.findByLoginAndPassword(login, password);
	}
	public List<Compte> getAll()
	{
		return daoCompte.findAll();
	}
	public Compte create(Compte compte) 
	{
		compte = daoCompte.save(compte);
		return compte;
	}
	
	public Compte update(Compte compte) 
	{
		compte = daoCompte.save(compte);
		return compte;
	}
	public boolean deleteById(Integer id) 
	{
		daoCompte.delete(id);
		return true;
	}
	public boolean delete(Compte compte) throws Exception 
	{
		if(compte.getId()==null) 
		{
			throw new Exception("Impossible de supprimer un compte qui n'a pas d'id");
		}
		deleteById(compte.getId());
		return true;
	}
}
