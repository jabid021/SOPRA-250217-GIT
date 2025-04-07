package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {
		
		//Config principale en XML
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		 
		Guitariste guitariste = (Guitariste) ctx.getBean("guitariste");
		Pianiste pianiste = (Pianiste) ctx.getBean("pianiste");
		Flutiste flutiste = (Flutiste) ctx.getBean("flutiste");
		
		
		
		
		pianiste.jouer();
		guitariste.jouer();
		flutiste.jouer();
		
		
		
		
	}

}
