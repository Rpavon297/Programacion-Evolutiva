package mutaciones;

import poblacion.Poblacion;

import java.util.List;

public class FactoriaMutacion {

    private static Mutacion getAlgoritmoMutacion(String mutacion){
        Mutacion mut;
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
            default:
                mut = new Insercion();
                break;
        }
        return mut;

    }


    public static Mutacion mutarPoblacion(String nmutacion, Poblacion poblacion, List<Double> params) {

        Mutacion mutacion = getAlgoritmoMutacion(nmutacion);
        mutacion.mutar(poblacion.getPoblacion(), params);
        return mutacion;
    }
}
