package quest.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.config.AppConfig;

public class SpringApplication {

	public static void main(String[] args) {
		//Config principale en XML
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ctx.getBeanFactory().createBean(TestSpring.class).run();
		ctx.close();
	}




}
