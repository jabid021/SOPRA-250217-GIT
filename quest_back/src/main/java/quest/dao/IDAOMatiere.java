package quest.dao;

import quest.model.Matiere;

public interface IDAOMatiere extends IDAO<Matiere,Integer>{

	
	public Matiere findByLib(String lib);
}
	