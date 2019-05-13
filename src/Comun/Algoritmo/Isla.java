package Comun.Algoritmo;

import Comun.Cruces.FactoriaCruces;
import Comun.Funcion.Funcion;
import Comun.Genetica.Gen;
import Comun.Genetica.GenBinario;
import Comun.Genetica.GenEntero;
import Comun.Genetica.GenReal;
import Comun.Mutaciones.FactoriaMutacion;
import Comun.Poblacion.Individuo;
import Comun.Poblacion.Poblacion;
import Comun.Selecciones.FactoriaSeleccion;
import Practica1.Funciones.Funcion1;
import Practica1.Funciones.Funcion2;
import Practica1.Funciones.Funcion3;
import Practica1.Funciones.Funcion4;
import Practica2.Funcion.FuncionViajante;
import Practica3.FuncionHormiga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Isla extends Thread {
    private AlgoritmoParalelos mainThread;

    /**
     * Argumentos de la ejecucion del algoritmo

    int funcion;
    int paramsFuncion;
    int poblacionSize;
    int numGeneraciones;

    String seleccion;
    String cruce;
    String mutacion;

    double probabilidadCruce;
    double probabilidadMutacion;
    double precision;

    boolean elitismo;
    double percentElitismo;
    double parametroTruncProb;

    int parametroCruce;
    int ciudadInicio;
     */

    /**
     * Atributos propios
     *
     * islaID la define dentro de la poblacion de islas
     */

    private int islaID;
    private int epocas;

    private List<Double> paramsCruce;
    private List<Double> paramsMutacion;
    private Funcion f;
    private volatile Poblacion poblacion;

    private boolean elitismo;
    private int numGeneraciones;
    private double percentElitismo;
    private double parametroTruncProb;

    private String seleccion;
    private String cruce;
    private String mutacion;

    private List<Generacion> generaciones;


    public Isla(AlgoritmoParalelos mainThread, List<Double> paramsCruce, List<Double> paramsMutacion, Funcion f,
                Poblacion poblacion, boolean elitismo, int numGeneraciones, double percentElitismo,
                double parametroTruncProb, String seleccion, String cruce, String mutacion, List<Generacion> generaciones,
                int islaID, int epocas) {
        this.mainThread = mainThread;
        this.paramsCruce = paramsCruce;
        this.paramsMutacion = paramsMutacion;
        this.f = f;
        this.poblacion = poblacion;
        this.elitismo = elitismo;
        this.numGeneraciones = numGeneraciones;
        this.percentElitismo = percentElitismo;
        this.parametroTruncProb = parametroTruncProb;
        this.seleccion = seleccion;
        this.cruce = cruce;
        this.mutacion = mutacion;
        this.generaciones = generaciones;
        this.islaID = islaID;
        this.epocas = epocas;
    }

    public void run(){
        for(int n = 0; n < epocas; n++) {
            System.out.println("Empieza en la isla " + islaID +" la epoca " + n);
            int salvados = (int) Math.ceil(poblacion.getPoblacion().size() * percentElitismo);
            Poblacion elite = new Poblacion();

            //INICIO DEL ALGORITMO

            //EVALUAR LA POBLACION INICIAL
            double fitnessTotal = actualizarPoblacion(poblacion);

            for (int i = 0; i < numGeneraciones; i++) {
                generaciones.add(new Generacion(poblacion, fitnessTotal));

                //GUARDAR ELITE
                if (elitismo)
                    elite = new Poblacion(poblacion.getPoblacion().subList(0, salvados + 1));

                //SELECCIONAR POBLACION
                Poblacion pobsel = new Poblacion(FactoriaSeleccion.getAlgoritmoSeleccion(seleccion, poblacion.getPoblacion(), parametroTruncProb).getPobSeleccionada());
                //CRUZAR POBLACION
                poblacion.substitute(FactoriaCruces.cruzarPoblacion(pobsel, cruce, paramsCruce));

                //MUTAR POBLACION
                poblacion = new Poblacion(FactoriaMutacion.mutarPoblacion(mutacion, poblacion, paramsMutacion).getPobMutada());
                //EVALUAR POBLACION
                fitnessTotal = actualizarPoblacion(poblacion);
                //REINTRODUCIR ELITE
                poblacion.substitute(elite);
                //REEVALUAR CON LA ELITE
                fitnessTotal = actualizarPoblacion(poblacion);
            }
            System.out.println("Acabada en la isla " + islaID +" la epoca " + n);
            this.mainThread.done(this.poblacion, this.islaID, this.generaciones, paramsCruce, paramsMutacion, f, elitismo, numGeneraciones, percentElitismo, parametroTruncProb, seleccion, cruce, mutacion);
        }
    }

    public void ordenarPoblacion(Poblacion poblacion){
        Collections.sort(poblacion.getPoblacion(), new Comparator<Individuo>() {
            @Override
            public int compare(Individuo i1, Individuo i2) {
                return new Double(i2.getFitnessAdaptado()).compareTo(new Double(i1.getFitnessAdaptado()));
            }
        });
    }

    public double actualizarPoblacion(Poblacion poblacion) {
        for(Individuo ind : poblacion.getPoblacion()) {
            List<Double> lista = ind.getFenotipo();
            ind.setFitness(f.ejecutar(lista));
        }
        poblacion.revisarAdaptacion(true);

        double fitnessTotal = 0;
        double fitnessTotalNA = 0;

        for(Individuo ind : poblacion.getPoblacion()){
            fitnessTotal += ind.getFitnessAdaptado();
            fitnessTotalNA += ind.getFitness();
        }

        ordenarPoblacion(poblacion);
        poblacion.setProbSeleccion(fitnessTotal);

        return fitnessTotalNA;
    }

    public int getIDIsla() {
        return islaID;
    }
}
