package quest.test;

import java.time.LocalDate;
import java.time.Month;

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
import quest.model.Filiere;
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
		
		Filiere filiereJava = new Filiere("JAVA SOPRA", LocalDate.of(2025, Month.FEBRUARY, 17), LocalDate.of(2025, Month.MAY, 20));
		filiereJava = daoFiliere.save(filiereJava);
		
		quest.model.Module filiereJavaHtml = new quest.model.Module(2544, 2, filiereJava, html);
		filiereJavaHtml = daoModule.save(filiereJavaHtml);
		
		quest.model.Module filiereJavaJs = new quest.model.Module(8844, 3, filiereJava, js);
		filiereJavaJs = daoModule.save(filiereJavaJs);
		
		quest.model.Module filiereJavaSpringCore = new quest.model.Module(6668, 3, filiereJava, springCore);
		filiereJavaSpringCore = daoModule.save(filiereJavaSpringCore);
	}
}
