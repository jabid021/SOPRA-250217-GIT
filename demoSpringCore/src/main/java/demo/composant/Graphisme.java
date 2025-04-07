package demo.composant;

import org.springframework.stereotype.Component;

@Component
public class Graphisme implements IConfig{
	
	private boolean fenetre;
	
	public Graphisme() {
		System.out.println("Creation du composant Graphisme");
		fenetre=true;
	}

	
	public boolean isFenetre() {
		return fenetre;
	}


	public void setFenetre(boolean fenetre) {
		this.fenetre = fenetre;
	}

	
	@Override
	public String toString() {
		return "Graphisme [fenetre=" + fenetre + "]";
	}

	
	
	
}
