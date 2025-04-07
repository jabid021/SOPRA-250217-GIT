package demo.aspect;

public class DemoAspect {
	
	
	public void saveBeforeQuit() 
	{
		System.out.println("On lance une save des infos de la partie en bdd");
	}
	
	
	
	
	public void logAfterQuit() 
	{
		System.out.println("La partie s'est bien quit");
	}

	
	
	public void afterGameValid(boolean resultatBoolean) 
	{
		System.out.println(resultatBoolean);
	}
}
