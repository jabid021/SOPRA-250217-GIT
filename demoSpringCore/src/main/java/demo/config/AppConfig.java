package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;

@Configuration
@ComponentScan("demo.composant")
//Notre config Principale Java a besoin de config supp dans le fichier xml
//@ImportResource("classpath:application-context.xml") 

public class AppConfig {

	
	@Bean(name = "audioCustom")
	public Audio audio() 
	{
		Audio audio = new Audio();
		audio.setVolume(90);
		return audio;
	}
	
	
	
	
}
