package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAspect {
	
	public void saveBeforeQuit() 
	{
		System.out.println("On lance une save des infos de la partie en bdd");
	}

	
	public void logAfterQuit() 
	{
		System.out.println("La partie s'est bien quit");
	}

	
	
	public void fonctionAutourQuit(ProceedingJoinPoint pj) throws Throwable 
	{
		System.out.println("--On lance une save des infos de la partie en bdd");
		
		//gameQuit();
		pj.proceed();
		
		System.out.println("--La partie s'est bien quit");
	}
	
	
	public void afterGameValid(String paramString,boolean resultatBoolean) 
	{
		System.out.println(resultatBoolean);
		System.out.println(paramString);
	}
}
