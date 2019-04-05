package Comun.Selecciones;

import java.util.List;

import Comun.Poblacion.Individuo;

public abstract class AlgoritmoSeleccion {
	
	protected List<Individuo> pobSeleccionada;
	

	public List<Individuo> getPobSeleccionada() {
		return pobSeleccionada;
	}

	public void setPobSeleccionada(List<Individuo> pobSeleccionada) {
		this.pobSeleccionada = pobSeleccionada;
	}
	
	public abstract void seleccion(List<Individuo> poblacion, Object param);
}
