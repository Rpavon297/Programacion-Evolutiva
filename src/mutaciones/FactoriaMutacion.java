package mutaciones;

import poblacion.Poblacion;

import java.util.List;

public class FactoriaMutacion {

    private static Mutacion getAlgoritmoMutacion(String mutacion){
        Mutacion mut;
        switch (mutacion){
            case "MutacionBasica":
                mut = new MutacionBasica();
                break;
            case "MutacionIntercambio":
                mut = new MutacionIntercambio();
                break;
            default:
                mut = new MutacionInsercion();
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
