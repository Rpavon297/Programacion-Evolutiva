package Comun.Selecciones;

import java.util.ArrayList;
import java.util.List;

import Comun.Poblacion.Individuo;

public class Ruleta extends AlgoritmoSeleccion{
	
	public void seleccion(List<Individuo> poblacion, Object param) {
		
		pobSeleccionada = new ArrayList<Individuo>();
		double p;
		int posSuper;
		
		for(int i = 0; i < (int)param; i++){
			p = Math.random();
			posSuper = 0;
			while(p > poblacion.get(posSuper).getAcumulado() && posSuper < poblacion.size())
				posSuper++;
			pobSeleccionada.add(i, poblacion.get(posSuper));
		}
	}
}
