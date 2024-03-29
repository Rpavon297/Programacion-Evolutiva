package Comun.Mutaciones;

import Practica1.Mutaciones.Basica;
import Practica2.Mutaciones.Heuristica;
import Practica2.Mutaciones.Insercion;
import Practica2.Mutaciones.Intercambio;
import Practica2.Mutaciones.Inversion;
import Comun.Poblacion.Poblacion;
import Practica3.Mutaciones.Funcion;
import Practica3.Mutaciones.Inicializacion;
import Practica3.Mutaciones.Terminal;

import java.util.List;

public class FactoriaMutacion {

    private static AlgoritmoMutacion getAlgoritmoMutacion(String mutacion){
        AlgoritmoMutacion mut;
        switch (mutacion){
            case "Basica":
                mut = new Basica();
                break;
            case "Intercambio":
                mut = new Intercambio();
                break;
            case "Inversion":
                mut = new Inversion();
                break;
            case "Heuristica":
                mut = new Heuristica();
                break;
            case "Terminal":
                mut = new Terminal();
                break;
            case "Funcion":
                mut = new Funcion();
                break;
            case "Inicializacion":
                mut = new Inicializacion();
                break;
            default:
                mut = new Insercion();
                break;
        }
        return mut;

    }


    public static AlgoritmoMutacion mutarPoblacion(String nmutacion, Poblacion poblacion, List<Double> params) {

        AlgoritmoMutacion mutacion = getAlgoritmoMutacion(nmutacion);
        mutacion.mutar(poblacion.getPoblacion(), params);
        return mutacion;
    }
}
