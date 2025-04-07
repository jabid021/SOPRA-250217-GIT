package orchestre.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.config.AppConfig;
import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {
		
		//Config principale en XML
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		 
		Guitariste guitariste = (Guitariste) ctx.getBean("guitariste");
		Pianiste pianiste = (Pianiste) ctx.getBean("pianiste");
		Flutiste flutiste = (Flutiste) ctx.getBean("flutiste");
		
		
		
		
		pianiste.jouer();
		guitariste.jouer();
		flutiste.jouer();
		
		
		
		
	}

}
