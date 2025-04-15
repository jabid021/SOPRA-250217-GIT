package quest;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOUtilisateur;
import quest.model.Filiere;
import quest.model.Genre;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

@SpringBootTest
class QuestBootApplicationTests {
	
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
	void contextLoads() {
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
		
		Stagiaire guillaume = new Stagiaire("gbaillot", "123456", "BAILLOT", "Guillaume", Genre.homme, "gbaillot@gmail.com", "8", "rue de la Paix", "Paris", "75008", filiereJava);
		guillaume = daoUtilisateur.save(guillaume);
		
		Stagiaire marina = new Stagiaire("maubry", "123456", "AUBRY", "Marina", Genre.femme, "maubry@gmail.com", "8", "rue de la Paix", "Paris", "75008", filiereJava);
		marina = daoUtilisateur.save(marina);
		
		Stagiaire maxence = new Stagiaire("mpalkowski", "123456", "PALKOWSKI", "Maxence", Genre.homme, "mpalkowski@gmail.com", "8", "rue de la Paix", "Paris", "75008", filiereJava);
		maxence = daoUtilisateur.save(maxence);
		
		
		Ordinateur ordiGuillaume = new Ordinateur("ASUS", 16, guillaume);
		ordiGuillaume = daoOrdinateur.save(ordiGuillaume);
		
		Ordinateur ordiMarina = new Ordinateur("HP", 32, marina);
		ordiMarina = daoOrdinateur.save(ordiMarina);
	}

}
