package eshop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;

public class SpringApplication {

	public static void main(String[] args) {
		//Config principale en XML
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ctx.getBeanFactory().createBean(TestSpringJPA.class).run();
		ctx.close();
	}




}
