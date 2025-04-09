package orchestre.model;

public class Voiture {

	private String marque;
	private int vitesse;
	private boolean isArret;
	
	public Voiture(String marque) {
		this.marque = marque;
		this.vitesse=0;
		this.isArret=true;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isArret() {
		return isArret;
	}

	public void setArret(boolean isArret) {
		this.isArret = isArret;
	}

	
	public void start(int vitesse) 
	{
		this.vitesse=vitesse;
		this.isArret=false;
	}
	
	
	public void stop() 
	{
		this.vitesse=0;
		this.isArret=true;
	}
	
	
	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", vitesse=" + vitesse + ", isArret=" + isArret + "]";
	}
	
	
	
	
}
