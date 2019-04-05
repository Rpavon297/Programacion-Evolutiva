package Comun.Algoritmo;

import Comun.Poblacion.Poblacion;

import java.util.ArrayList;
import java.util.List;

class Generacion {
    private final double mejor;
    private final double peor;
    private final double media;
    private final List<Double> solucion;

    public Generacion(Poblacion poblacion, double fitnessTotal){
        //Calculamos maximo, minimo, media y maximo absoluto. La solucion ser� el maximo absoluto en la ultima generacion
        this.mejor = poblacion.getPoblacion().get(0).getFitness();
        this.peor = poblacion.getPoblacion().get(poblacion.getPoblacion().size() - 1).getFitness();
        this.media = fitnessTotal / poblacion.getPoblacion().size();

        this.solucion = new ArrayList<>();
        this.solucion.addAll(poblacion.getPoblacion().get(0).getFenotipo());
    }

    public double getMejor() {
        return mejor;
    }

    public double getPeor() {
        return peor;
    }

    public double getMedia() {
        return media;
    }

    public List<Double> getSolucion() {
        return solucion;
    }

}
