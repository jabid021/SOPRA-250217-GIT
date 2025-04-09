package orchestre.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {

	@BeforeClass
	public static void debut() 
	{
		System.out.println("Debut des test SuperMaths");
	}


	@Test
	public void constructeur() 
	{
		//Arrange
		SuperMaths s;

		//Act
		s = new SuperMaths();
		//Assert
		assertNotNull(s);
	}

	@Test
	public void add() 
	{
		//Arrange
		int a=1;
		int b=5;
		SuperMaths s = new SuperMaths();
		int resultat;	
		//Act
		resultat=s.additionner(a, b);
			
		//Assert
		assertTrue(6==resultat);
	}


	@Test
	public void minus() 
	{

		//Arrange
		int a=6;
		int b=5;
		SuperMaths s = new SuperMaths();
		int resultat;
		//Act
		resultat = s.soustraire(a, b);
		//Assert
		assertFalse(0==resultat);
	}
}
