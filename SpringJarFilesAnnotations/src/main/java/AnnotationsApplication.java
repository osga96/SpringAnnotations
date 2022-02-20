package main.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.interfaces.Empleado;

public class AnnotationsApplication {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/resources/applicationContext.xml");
		
		Empleado pedro = context.getBean("ComercialExperimentado", Empleado.class);

		System.out.println(pedro.getTareas());
		System.out.println(pedro.getInforme());
		
		context.close();
		
	}

}
