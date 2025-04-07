package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.config.AppConfig;
import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

public class Test {

	@Autowired 
	IMusicien guitariste;
	
	@Autowired 
	IMusicien pianiste;
	
	@Autowired 
	IMusicien flutiste;
	
	
	public void run(String[] ...args) {
		

		 
		/*Guitariste guitariste = (Guitariste) ctx.getBean("guitariste");
		Pianiste pianiste = (Pianiste) ctx.getBean("pianiste");
		Flutiste flutiste = (Flutiste) ctx.getBean("flutiste");
		*/
		
		
		
		pianiste.jouer();
		guitariste.jouer();
		flutiste.jouer();
		
		
		
		
	}

}
