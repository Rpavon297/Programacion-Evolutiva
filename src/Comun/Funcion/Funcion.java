package Comun.Funcion;

import java.util.List;

public abstract class Funcion {
	protected List<Double> intervalo;

	public abstract double ejecutar(List<Double> x);
	public List<Double> getIntervalo(){return this.intervalo;}
}
