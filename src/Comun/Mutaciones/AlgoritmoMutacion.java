package Comun.Mutaciones;

import java.util.List;

import Comun.Poblacion.Individuo;

public abstract class AlgoritmoMutacion {

	protected List<Individuo> nPoblacion;
	
	public abstract void mutar(List<Individuo> poblacion, List<Double> params);
	
	public List<Individuo> getPobMutada(){return nPoblacion;}
	
}
