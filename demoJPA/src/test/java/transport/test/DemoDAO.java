package transport.test;

import transport.context.Singleton;
import transport.model.Arret;
import transport.model.Transport;

public class DemoDAO {

	public static void main(String[] args) {
	
		
		for(Transport t : Singleton.getInstance().getDaoTransport().findAll()) 
		{
			System.out.println(t);
		}
		
		for(Arret a : Singleton.getInstance().getDaoArret().findAll()) 
		{
			System.out.println(a);
		}
		
		
		System.out.println(Singleton.getInstance().getDaoPassager().findById(1));
		System.out.println(Singleton.getInstance().getDaoBillet().findById(1));
	}

}
