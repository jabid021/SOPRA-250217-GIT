package hopital.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import hopital.context.Singleton;

public class TomcatListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		
		System.out.println("Start Tomcat");
		//Avec JPA + Tomcat + Maven + Eclipse => le driver mysql n'est pas correctement chargé dans le projet front, obligé de le charger manuellement
		try {Class.forName("com.mysql.jdbc.Driver");} catch (ClassNotFoundException e) {e.printStackTrace();}
		Singleton.getInstance();
	}

	public void contextDestroyed(ServletContextEvent sce)  { 
		System.out.println("Stop Tomcat");
		Singleton.getInstance().closeEmf();
	}



}
