package quest.test;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOOrdinateur;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.service.MatiereService;

public class TestSpring {
	
	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	MatiereService matiereSrv;
	
	@Autowired
	IDAOFiliere daoFiliere;
	
	
	public void run() 
	{
		System.out.println("Run Test");
		
		//System.out.println(daoFiliere.findByIdWithStagiaires(1));
		System.out.println(matiereSrv.getByLibelle("Formation"));
		
		System.out.println("LISTE DES ORDINATEURS");
		for(Ordinateur o : daoOrdinateur.findAll()) {System.out.println(o);}
		
		System.out.println(daoOrdinateur.findById(1).get());
		
		
		System.out.println("LISTE DES MATIERES");
		for(Matiere m : matiereSrv.getAll()) {System.out.println(m);}
		
		
		System.out.println();
		
		//System.out.println(matiereSrv.getByLibelle("TOTO"));
	}
}
