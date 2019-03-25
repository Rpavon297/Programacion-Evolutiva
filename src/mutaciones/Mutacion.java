package mutaciones;

import java.util.List;

import poblacion.Individuo;

public abstract class Mutacion {

	protected List<Individuo> nPoblacion;
	
	public abstract void mutar(List<Individuo> poblacion, List<Double> params);
	
	public List<Individuo> getPobMutada(){return nPoblacion;}
	
}
