package Practica2.Funcion;

import Practica2.Mapa;
import Comun.Funcion.Funcion;

import java.util.ArrayList;
import java.util.List;

public class FuncionViajante extends Funcion {

    public FuncionViajante(){
        this.intervalo = new ArrayList<>();
        this.intervalo.add(0.0);
        this.intervalo.add(26.0);
    }
    @Override
    public double ejecutar(List<Double> x) {
        double acum = 0;

        for(int i = 0; i < x.size()-1; i++)
            acum += Mapa.calcularDistancias( x.get(i).intValue(), x.get(i+1).intValue());

        return acum;

    }
}
