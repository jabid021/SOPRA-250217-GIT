package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {

	@AfterReturning(pointcut = "execution(public String orchestre.model.Guitariste.toString())",returning = "messageToString")
	public void afterToStringGuitariste(String messageToString) 
	{
		System.out.println(messageToString);
		System.out.println("Le guitariste vient de se presenter");
	}
	
	@Pointcut("execution(public void orchestre.model.Guitariste.jouer())")
	public void methodeJouer() {}
	
	
	@Before("methodeJouer()")
	 public void installer(){System.out.println("Le public s'installe");}
	@AfterReturning("methodeJouer()")
	 public void applaudir(){System.out.println("Le public applaudit");}
	@AfterThrowing("methodeJouer()")
	 public void huer(){System.out.println("Le public jette des tomates");}
}
