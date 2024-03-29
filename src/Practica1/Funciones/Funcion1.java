package Practica1.Funciones;

import Comun.Funcion.Funcion;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Funcion1 extends Funcion {

	public Funcion1(){
		intervalo = new ArrayList();
		intervalo.add(-3.0);
		intervalo.add(12.1);
		intervalo.add(4.1);
		intervalo.add(5.8);
	}
	@Override
	public double ejecutar(List<Double> x) {
        return 21.5 + (x.get(0) * Math.sin(4 * Math.PI * x.get(0))) +
                (x.get(1) * Math.sin(20 * Math.PI * x.get(1)));
	}
}
