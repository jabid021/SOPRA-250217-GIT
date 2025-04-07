package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.config.AppConfig;

public class SpringApplication {


	public static void main(String[] args) {
		//Pour que Spring fonctionne, il faut une config Principale (soit en xml avec application-context soit en Java avec une classe de Config)
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		// Config Java
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		 ctx.getBeanFactory().createBean(Test.class).run();
		 ctx.close();
	}
}
