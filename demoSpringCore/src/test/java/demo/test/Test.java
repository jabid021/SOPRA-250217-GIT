package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;

public class Test {

	public static void main(String[] args) {

	
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		 
		
		Audio settingAudio=(Audio) ctx.getBean("audio");

		System.out.println(settingAudio);
		
		
		System.out.println(ctx.getBean(Graphisme.class));
		
		
		Game g1 = (Game) ctx.getBean("game");
		System.out.println(g1);
		

	}

}
