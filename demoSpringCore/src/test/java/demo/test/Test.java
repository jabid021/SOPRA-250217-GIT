package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;
import demo.config.AppConfig;

public class Test {

	public static void main(String[] args) {

		//Pour que Spring fonctionne, il faut une config Principale (soit en xml avec application-context soit en Java avec une classe de Config)
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		 // Config Java
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Audio settingAudio=(Audio) ctx.getBean("audio");
		Audio audio2=(Audio) ctx.getBean("audioCustom");
		System.out.println(settingAudio +" bean genere @Component audio");
		System.out.println(audio2 + " bean cree dans appConfig audio2");
		
		System.out.println(ctx.getBean("graphisme",Graphisme.class));
		
		Game g1 = (Game) ctx.getBean("game");
		System.out.println(g1);

	}

}
