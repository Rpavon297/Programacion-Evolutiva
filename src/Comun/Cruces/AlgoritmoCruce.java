package Comun.Cruces;

import java.util.List;

import Comun.Poblacion.Individuo;

public abstract class AlgoritmoCruce {
	
	protected List<Individuo> hijos;
	
	public List<Individuo> getHijos() {
		return this.hijos;
	}
	
	public abstract void cruzar(Individuo padre1, Individuo padre2, int param);
}
