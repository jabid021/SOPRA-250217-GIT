package quest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import quest.config.AppConfig;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOUtilisateur;
import quest.model.Matiere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestPopulate {
	@Autowired
	private IDAOFiliere daoFiliere;
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@Autowired
	private IDAOModule daoModule;
	
	@Autowired
	private IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@Test
	public void populate() {
		Matiere html = new Matiere("HTML");
		html = daoMatiere.save(html);
		
		Matiere js = new Matiere("JAVASCRIPT");
		js = daoMatiere.save(js);
		
		Matiere springCore = new Matiere("SPRING CORE");
		springCore = daoMatiere.save(springCore);
	}
}
