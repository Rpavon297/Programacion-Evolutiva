package selecciones;

import java.util.ArrayList;
import java.util.List;

import poblacion.Individuo;

public class Truncamiento extends AlgoritmoSeleccion{
	
	

	@SuppressWarnings("unchecked")
	public void seleccion(List<Individuo> poblacion, Object param) {		
		
		double aElegir = (double) param;
		double veces = 1.0 / (double) param;
		pobSeleccionada = new ArrayList<Individuo>();
		
		for(int i = 0; i < aElegir; i++)
			for(int j = 0; j < veces; j++)
				pobSeleccionada.add(poblacion.get(i));
	}
}
