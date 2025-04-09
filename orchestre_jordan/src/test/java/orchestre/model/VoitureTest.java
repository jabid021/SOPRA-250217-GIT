package orchestre.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VoitureTest {
	
	@Test
	public void creationVoiture() 
	{
		//Arrange
		Voiture v;
		
		//Act
		v = new Voiture("BMW");
		
		//Assert
		assertNotNull(v);
		assertEquals("BMW", v.getMarque());
		assertTrue(0==v.getVitesse());
		assertTrue(true==v.isArret());
	}
	
	@Test
	public void startTest() 
	{
		//Arrange
		Voiture v = new Voiture("BMW");
		//Act
		v.start(100);
		//Assert
		//assertTrue(100==v.getVitesse());
		assertFalse(0==v.getVitesse());
		assertTrue(false==v.isArret());	
	}
	
	
	
	@Test
	public void stopTest() 
	{
		//Arrange
		Voiture v = new Voiture("BMW");
		v.start(100);
		//Act
		v.stop();
		//Assert
		assertTrue(0==v.getVitesse());
		assertTrue(true==v.isArret());	
	}
	
	
	
}
