package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.model.Guitariste;
import orchestre.model.IMusicien;

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
		
		
		
	/*	pianiste.jouer();
		
		flutiste.jouer();
		*/
		guitariste.jouer();
		//guitariste.toString();
		

	}

}
