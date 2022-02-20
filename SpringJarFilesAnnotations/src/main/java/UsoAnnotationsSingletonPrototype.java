package main.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import main.java.interfaces.Empleado;

public class UsoAnnotationsSingletonPrototype {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/Resources/applicationContext.xml");

		Empleado juan = context.getBean("ComercialExperimentado", Empleado.class);
		Empleado lucia = context.getBean("ComercialExperimentado", Empleado.class);

		System.out.println(juan.getInforme());
		System.out.println(juan.getTareas());
		System.out.println(lucia.getInforme());
		System.out.println(lucia.getTareas());

		System.out.println(juan);
		System.out.println(lucia);
		

		System.out.println(juan.equals(lucia));
		
		context.close();
		
	}

}
