package Practica1.Funciones;

import Comun.Funcion.Funcion;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Funcion2 extends Funcion {

	public Funcion2(){
		intervalo = new ArrayList();
		intervalo.add(-512.0);
		intervalo.add(512.0);
	}
	
	@Override
	public double ejecutar(List<Double> x) {
		return -(x.get(1) + 47) * Math.sin(Math.sqrt(Math.abs(x.get(1) + (x.get(0)/2) + 47))) -
				x.get(0) * Math.sin(Math.sqrt(Math.abs(x.get(0) - (x.get(1) + 47))));
	}
}
