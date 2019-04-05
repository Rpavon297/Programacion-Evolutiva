package Comun.Algoritmo;

import Comun.Poblacion.Poblacion;

import java.util.ArrayList;
import java.util.List;

public class Generacion {
    private double mejor;
    private double peor;
    private double media;
    private List<Double> solucion;

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

    public void setMejor(double mejor) {
        this.mejor = mejor;
    }

    public double getPeor() {
        return peor;
    }

    public void setPeor(double peor) {
        this.peor = peor;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public List<Double> getSolucion() {
        return solucion;
    }

    public void setSolucion(List<Double> solucion) {
        this.solucion = solucion;
    }
}
