package main.java.objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import main.java.interfaces.CreacionInformeFinanciero;
import main.java.interfaces.Empleado;

// si lo dejamos sin "ComercialExperimentado", sería el nombre en minúscula
@Component("ComercialExperimentado")

// comentamos el scope si necesitamos usar las anotaciones de @PostConstruct y/o @PreDestroy
// @Scope("prototype")
public class ComercialExperimentado implements Empleado {

	// donde se meta autowired, hará que se inyecte el objeto
	//@Autowired
	private CreacionInformeFinanciero informeFinanciero;

	// Si hay dos constructores, autowired es necesario, si no no. (Se pone siempre por buenas practicas).
	/*public ComercialExperimentado() {
		
	}*/
	
	// Autowired busca en todo el proeycto a ver si alguna clase implementa la clase CreacionInformeFinanciero, luego de la clase que encuentra, obtiene de ella la inyección de dependencia, en este caso InformeFinancieroTrimestreUno
	/*@Autowired
	public ComercialExperimentado(CreacionInformeFinanciero informeFinanciero) {
		super();
		this.informeFinanciero = informeFinanciero;
	}*/

	@Override
	public String getTareas() {
		return "vender";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		// return "informe experimentado";
		return informeFinanciero.getInformeFinanciero();
	}

	/*@Autowired
	public void setInformeFinanciero(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}*/
	
	@Autowired
	// Si tenemos más de un objeto que implementa CreacionInformeFinanciero, debemos darle un qualifier que indique cual es el objeto que debe inyectar.
	@Qualifier("informeFinancieroTrimestreTres")
	public void testUnDosTresNoSeUsa(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}


	// INIT (CUANDO EL BEAN ESTÁ DISPONIBLE, CREADO) ###NO SE PUEDE USAR CON PROTOTYPE, QUITAMOS EL SCOPE###, no deben tener argumentos
	@PostConstruct
	public void metodoInitAbrimosConexionABaseDeDatos() {
		System.out.println("init");
	}

	// DESTROY (CUANDO EL BEAN SE DESTRUYE Y SE APAGA EL CONTENEDOR DE SPRING) ###NO SE PUEDE USAR CON PROTOTYPE, QUITAMOS EL SCOPE###, no deben tener argumentos
	@PreDestroy
	public void metodoDestroyCerramosLoNecesario() {
		System.out.println("destroy");
	}

}
