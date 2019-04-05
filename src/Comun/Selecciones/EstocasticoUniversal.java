package Comun.Selecciones;

import java.util.ArrayList;
import java.util.List;

import Comun.Poblacion.Individuo;

public class EstocasticoUniversal extends AlgoritmoSeleccion{
	

	public void seleccion(List<Individuo> poblacion, Object param) {
		
		pobSeleccionada = new ArrayList<Individuo>();
		double p = Math.random() * (1.0/(int)param);
	
		for(int i = 0; i < (int)param; i++){
			int posSuper = 0;
			while(posSuper < poblacion.size() && p > poblacion.get(posSuper).getAcumulado())
				posSuper++;
			pobSeleccionada.add(i, poblacion.get(posSuper));
			p = p + (1.0/(int)param);
		}
		
		
	}
}
