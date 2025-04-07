package demo.composant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {

	@Autowired
	private Graphisme graphisme;
	
	@Autowired
	@Qualifier("audio")
	private IConfig configAudio;
	
	public Game(Graphisme graphisme) 
	{
		System.out.println("Creation du GAME");
		System.out.println("On est dans le constructeur GAME "+ graphisme);
	}
	
	
	public Graphisme getGraphisme() {
		return graphisme;
	}

	public void setGraphisme(Graphisme graphisme) {
		this.graphisme = graphisme;
	}

	public IConfig getConfigAudio() {
		return configAudio;
	}

	public void setConfigAudio(IConfig configAudio) {
		this.configAudio = configAudio;
	}


	@Override
	public String toString() {
		return "Game [graphisme=" + graphisme + ", configAudio=" + configAudio + "]";
	}
	
	
	
	
	
}
