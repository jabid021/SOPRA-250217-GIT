package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;

public class Test {

	public static void main(String[] args) {

	
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		 
		
		Audio settingAudio=(Audio) ctx.getBean("beanAudio");
		Audio settingAudio2=(Audio) ctx.getBean("beanAudio2");
		
		System.out.println(ctx.getBean(Graphisme.class));
		System.out.println(settingAudio2);
		Game g1 = (Game) ctx.getBean("game");
		System.out.println(g1);
		

	}

}
