package main.java.objects;

import org.springframework.stereotype.Component;

import main.java.interfaces.CreacionInformeFinanciero;

@Component
public class InformeFinancieroTrimestreTres implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Informe del trimestre tres";
	}

}
