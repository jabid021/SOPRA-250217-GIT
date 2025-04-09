package orchestre.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonneTest {

	
	@BeforeClass
	public static void debutTest()
	{
		System.out.println("Debut des Test Personne");
	}
	
	
	@Test
	public void creationPersonne() 
	{
		//Arrange
		Personne p;
		String prenom="Jordan";
		String nom="Abid";
		int age = 31;
		
		//Act
		p = new Personne(nom,prenom,age);
		
		//Assert
		assertNotNull(p);
		assertEquals("Abid",p.getNom());
		assertEquals("Jordan", p.getPrenom());
		assertTrue(31==p.getAge());
	}
	
	
	@Test
	public void anniversaire() 
	{
		//Arrange
		Personne p =new Personne("Abid","Jordan",31);
		
		//Act
		p.anniversaire();
		
		//Assert
		assertTrue(32==p.getAge());
		/*if(p.getAge()!=32) 
		{
			fail();
		}*/
	}
	
}
