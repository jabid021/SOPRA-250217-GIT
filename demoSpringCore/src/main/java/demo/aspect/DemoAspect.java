package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class DemoAspect {
	
	
	@Pointcut("execution(public void demo.composant.Game.quitterPartie())")
	public void pointCut() {}
	
	@Before("pointCut()")
	public void saveBeforeQuit() 
	{
		System.out.println("On lance une save des infos de la partie en bdd");
	}

	@After("pointCut()")
	public void logAfterQuit() 
	{
		System.out.println("La partie s'est bien quit");
	}

	@Around("pointCut()")
	public void fonctionAutourQuit(ProceedingJoinPoint pj) throws Throwable 
	{
		System.out.println("--On lance une save des infos de la partie en bdd");
		
		//gameQuit();
		pj.proceed();
		
		System.out.println("--La partie s'est bien quit");
	}
	
	@AfterReturning(returning = "resultatBoolean", pointcut="execution(public boolean demo.composant.Game.gameValid(String)) && args(paramString)")
	public void afterGameValid(String paramString,boolean resultatBoolean) 
	{
		System.out.println(resultatBoolean);
		System.out.println(paramString);
	}
}
