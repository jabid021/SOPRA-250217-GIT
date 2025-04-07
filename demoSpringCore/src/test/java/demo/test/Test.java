package demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;
import demo.config.AppConfig;

public class Test {

	@Autowired
	@Qualifier("audio")
	Audio settingAudio;
	
	@Autowired
	Audio audioCustom;
	
	@Autowired
	Graphisme graphisme;
	
	@Autowired
	Game game;
	
	
	public void run(String[] ...args) {

		System.out.println("DEBUT DU MAIN");
		
		
		/*Audio settingAudio=(Audio) ctx.getBean("audio");
		Audio audio2=(Audio) ctx.getBean("audioCustom");
		System.out.println(settingAudio +" bean genere @Component audio");
		System.out.println(audio2 + " bean cree dans appConfig audio2");
		
		System.out.println(ctx.getBean("graphisme",Graphisme.class));
		
		Game g1 = (Game) ctx.getBean("game");*/
		System.out.println(game);

	}

}
